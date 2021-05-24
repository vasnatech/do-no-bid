package com.vasnatech.donobid.model;

import java.math.BigDecimal;
import java.time.Instant;

public class AssetBidEvent {

    String clientId;
    String auctionId;
    String assetId;

    String user;
    String correlation;

    String currency;
    BigDecimal winningAmount;
    BigDecimal winningUserAmount;
    String winningUserCurrency;
    BigDecimal previousWinningAmount;
    BigDecimal previousWinningUserAmount;
    String previousWinningUserCurrency;

    Instant statRequestTime;
    Instant statReceiveTime;
    Instant statQueuedTime;
    Instant statExecutionTime;
    Instant statResponseTime;
}
