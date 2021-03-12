package com.vasnatech.bidnobid.currency;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Currency;
import java.util.Map;

public class ExchangeRateCurrencyConverter implements CurrencyConverter {

    protected String baseCurrency;
    protected Map<String, BigDecimal> exchangeRates;

    public ExchangeRateCurrencyConverter(String baseCurrency, Map<String, BigDecimal> exchangeRates) {
        this.baseCurrency = baseCurrency;
        this.exchangeRates = exchangeRates;
    }

    public String getBaseCurrency() {
        return baseCurrency;
    }

    @Override
    public BigDecimal convert(BigDecimal sourceAmount, String sourceCurrency, String targetCurrency) {
        if (baseCurrency.equals(sourceCurrency)) {
            BigDecimal exchangeRate = exchangeRates.get(targetCurrency);
            if (exchangeRate == null)
                throw new IllegalStateException("Unable to find exchange rate between " + baseCurrency + " and " + targetCurrency);
            return exchangeRate.multiply(sourceAmount);
        }
        BigDecimal sourceExchangeRate = exchangeRates.get(sourceCurrency);
        if (sourceExchangeRate == null)
            throw new IllegalStateException("Unable to find exchange rate between " + baseCurrency + " and " + sourceCurrency);
        BigDecimal targetExchangeRate = exchangeRates.get(targetCurrency);
        if (targetExchangeRate == null)
            throw new IllegalStateException("Unable to find exchange rate between " + baseCurrency + " and " + targetCurrency);
        BigDecimal exchangeRate = targetExchangeRate.divide(sourceExchangeRate, RoundingMode.HALF_EVEN);
        return exchangeRate.multiply(sourceAmount);
    }
}