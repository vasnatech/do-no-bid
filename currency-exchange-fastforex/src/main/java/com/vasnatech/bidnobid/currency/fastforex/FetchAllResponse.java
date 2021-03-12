package com.vasnatech.bidnobid.currency.fastforex;

import java.math.BigDecimal;
import java.util.Map;

public class FetchAllResponse {

    String base;
    Map<String, BigDecimal> results;

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Map<String, BigDecimal> getResults() {
        return results;
    }

    public void setResults(Map<String, BigDecimal> results) {
        this.results = results;
    }
}
