package com.mywallet.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by vinay on 12/8/2017.
 */

public class ApiClient {
    public static final String BASE_URL = "https://graph.facebook.com/v3.0/me/";
   // public static final String BASE_URL = "http://www.paypre.info/";  http://paypre.info/DAILY_EQUIPMENT
    private static Retrofit retrofit = null;


    public static Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
