package com.dochdonatello.hotelapp.network;

import com.dochdonatello.hotelapp.data.remote.models.request.LoginRequest;
import com.dochdonatello.hotelapp.data.remote.models.response.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiNetwork {
    @POST("/api/oauth/token")
    Call<LoginResponse> login(@Body LoginRequest req);
}
