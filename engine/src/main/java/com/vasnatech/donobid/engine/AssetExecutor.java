package com.vasnatech.donobid.engine;

import com.vasnatech.commons.event.EventListeners;
import com.vasnatech.commons.event.Listener;
import com.vasnatech.commons.queue.BlockingQueueThread;
import com.vasnatech.donobid.log.Logger;
import com.vasnatech.donobid.model.Asset;
import com.vasnatech.donobid.model.AssetBidEvent;
import com.vasnatech.donobid.model.AssetBidRequest;

import java.math.BigDecimal;
import java.time.Duration;

public class AssetExecutor {

    static final Logger log = Logger.getLogger();
    
    static final int QUEUE_CAPACITY = 1000;
    static final Duration DEFAULT_OFFER_DURATION = Duration.ofSeconds(5);
    static final Duration DEFAULT_POLL_DURATION = Duration.ofSeconds(1);

    Asset asset;
    BigDecimal winningAmount;
    BigDecimal winningUserAmount;
    String winningUser;
    String winningUserCurrency;

    boolean threadsActive;

    final BlockingQueueThread<AssetBidRequest> bidRequestThread;
    final BlockingQueueThread<AssetBidEvent> bidEventThread;

    final EventListeners listeners;

    public AssetExecutor(Asset asset) {
        this.asset = asset;
        this.listeners = new EventListeners(log::error);
        this.bidRequestThread = BlockingQueueThread.builder(AssetBidRequest.class)
                .queueCapacity(QUEUE_CAPACITY)
                .pollDuration(DEFAULT_POLL_DURATION)
                .offerDuration(DEFAULT_OFFER_DURATION)
                .dataHandler(this::execute)
                .exceptionHandler(log::error)
                .build();
        this.bidEventThread = BlockingQueueThread.builder(AssetBidEvent.class)
                .queueCapacity(QUEUE_CAPACITY)
                .pollDuration(DEFAULT_POLL_DURATION)
                .offerDuration(DEFAULT_OFFER_DURATION)
                .dataHandler(this::fireAssetBidEvent)
                .exceptionHandler(log::error)
                .build();
    }

    public void stop() {
        bidRequestThread.stop();
        bidEventThread.stop();
    }

    void execute(AssetBidRequest bidRequest) {
    }

    public void addAssetBidListener(Listener<AssetBidEvent> listener) {
        listeners.add(AssetBidEvent.class, listener);
    }

    public void removeAssetBidListener(Listener<AssetBidEvent> listener) {
        listeners.remove(AssetBidEvent.class, listener);
    }

    void fireAssetBidEvent(AssetBidEvent bidEvent) {
        listeners.fire(bidEvent);
    }
}
