package com.vasnatech.bidnobid.currency.fastforex;

import com.vasnatech.bidnobid.currency.ExchangeRateCurrencyConverter;
import com.vasnatech.commons.http.HttpClientException;
import com.vasnatech.donobid.log.Logger;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class FastForexCurrencyConverter extends ExchangeRateCurrencyConverter {

    final Client client;

    final ScheduledExecutorService executorService;

    FastForexCurrencyConverter(Client client, String baseCurrency) {
        super(baseCurrency, new ConcurrentHashMap<>());
        this.client = client;

        this.executorService = Executors.newScheduledThreadPool(1);
        executorService.scheduleAtFixedRate(this::refreshExchangeRates, 0L, 5L, TimeUnit.SECONDS);
    }

    FastForexCurrencyConverter(String baseCurrency) {
        this(new Client(), baseCurrency);
    }

    void refreshExchangeRates() {
        try {
            exchangeRates.putAll(client.call(baseCurrency));
        } catch (HttpClientException e) {
            Logger.getLogger().error(e);
        }
    }

    public void stopRefreshExchangeRates() {
        executorService.shutdown();
    }


    public static void main(String[] args) throws InterruptedException {
        FastForexCurrencyConverter converter = new FastForexCurrencyConverter("USD");
        for (int index=0; index<100; ++index) {
            Thread.sleep(1000);
            BigDecimal rate = converter.convert(new BigDecimal("100.00"), "TRY", "CAD");
            System.out.println(rate);
            Thread.sleep(1000);
        }
    }
}
