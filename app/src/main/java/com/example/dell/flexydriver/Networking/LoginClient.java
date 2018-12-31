package com.example.dell.flexydriver.Networking;

import retrofit.RestAdapter;

public class LoginClient {
    public static LoginAPIInterface getClient() {
        String BASE_URL = "https://api.flexyapp.com/";

        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint(BASE_URL)
                .build();

        LoginAPIInterface api = adapter.create(LoginAPIInterface.class);
        return api;
    }
}
