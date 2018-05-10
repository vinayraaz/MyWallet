package com.mywallet.api;
import com.mywallet.model.FeedResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by vinay on 12/8/2017.
 */

public interface ApiInterface {
    //All Equipment List
    @GET("feed")
    Call<FeedResponse> getFeedResponse(@Query("access_token") String accesstoken);
    // Not Working API Calling

}


