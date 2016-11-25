package com.hld.retrofit2.network;

import com.hld.retrofit2.model.request.LoginRequestModel;
import com.hld.retrofit2.model.response.LoginResponseModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by hilda on 25/11/2016.
 */

public interface ApiInterface {

    @POST("api/login")
    Call<LoginResponseModel> login(@Body LoginRequestModel request);


}
