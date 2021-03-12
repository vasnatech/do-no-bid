package com.vasnatech.bidnobid.currency;

import java.math.BigDecimal;

public interface CurrencyConverter {

    BigDecimal convert(BigDecimal sourceAmount, String sourceCurrency, String targetCurrency);
}
