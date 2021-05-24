package com.vasnatech.donobid.model;

import java.time.Instant;
import java.util.List;

public class Auction {

    String id;

    Client client;
    List<Asset> assets;

    Instant start;
    Instant finish;

    public Auction() {
    }

    public Auction(String id, Client client, List<Asset> assets, Instant start, Instant finish) {
        this.id = id;
        this.client = client;
        this.assets = assets;
        this.start = start;
        this.finish = finish;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Asset> getAssets() {
        return assets;
    }

    public void setAssets(List<Asset> assets) {
        this.assets = assets;
    }

    public Instant getStart() {
        return start;
    }

    public void setStart(Instant start) {
        this.start = start;
    }

    public Instant getFinish() {
        return finish;
    }

    public void setFinish(Instant finish) {
        this.finish = finish;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Auction auction = (Auction) o;
        return id.equals(auction.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Auction{id=" + id + ", client=" + client + ", start=" + start + ", finish=" + finish + "}";
    }
}
