package com.vasnatech.bidnobid.currency.fastforex;

import com.vasnatech.commons.http.HttpClientFactory;
import com.vasnatech.commons.http.HttpEndpoint;
import com.vasnatech.commons.http.jdk.JdkHttpClientFactory;
import com.vasnatech.commons.json.Json;
import com.vasnatech.commons.json.jackson.Jackson;

import java.math.BigDecimal;
import java.util.Map;

public class Client {

    static {
        Json.setJson(Jackson.json());
        HttpClientFactory.setDefault(new JdkHttpClientFactory());
    }

    HttpEndpoint<Void, FetchAllResponse> fetchAll;

    Client(HttpEndpoint<Void, FetchAllResponse> fetchAll) {
        this.fetchAll = fetchAll;
    }

    public Client() {
        this(
            HttpEndpoint.builder(FetchAllResponse.class)
                .group("fastForex.io")
                .name("fetch-all")
                .deserializer(Json.decoder())
                .requestHeader("Accept", "application/json")
                .urlTemplate("https://api.fastforex.io/fetch-all?api_key=f924916294-5b95a3b809-qpf1c5&from={{from}}")
                .build()
        );
    }

    public Map<String, BigDecimal> call(String from) {
        FetchAllResponse response = fetchAll.sync()
                .parameter("from", from)
                .get();
        return response.results;
    }
}
