package com.vasnatech.donobid.model;

import java.math.BigDecimal;
import java.time.Instant;

public class AssetBidRequest extends Request {

    String clientId;
    String auctionId;
    String assetId;
    String user;
    String correlation;
    BigDecimal bidAmount;
    String bidCurrency;

    Instant statRequestTime;
    Instant statReceiveTime;

    public AssetBidRequest() {
    }

    public AssetBidRequest(
            String id,
            String clientId,
            String auctionId,
            String assetId,
            String user,
            String correlation,
            BigDecimal bidAmount,
            String bidCurrency,
            Instant statRequestTime
    ) {
        super(id);
        this.clientId = clientId;
        this.auctionId = auctionId;
        this.assetId = assetId;
        this.user = user;
        this.correlation = correlation;
        this.bidAmount = bidAmount;
        this.bidCurrency = bidCurrency;
        this.statRequestTime = statRequestTime;

        this.statReceiveTime = Instant.now();
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(String auctionId) {
        this.auctionId = auctionId;
    }

    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getCorrelation() {
        return correlation;
    }

    public void setCorrelation(String correlation) {
        this.correlation = correlation;
    }

    public BigDecimal getBidAmount() {
        return bidAmount;
    }

    public void setBidAmount(BigDecimal bidAmount) {
        this.bidAmount = bidAmount;
    }

    public String getBidCurrency() {
        return bidCurrency;
    }

    public void setBidCurrency(String bidCurrency) {
        this.bidCurrency = bidCurrency;
    }
}
