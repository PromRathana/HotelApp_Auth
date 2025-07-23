package com.dochdonatello.hotelapp.network;

import com.dochdonatello.hotelapp.data.remote.models.request.BaseRequest;
import com.dochdonatello.hotelapp.data.remote.models.request.LoginRequest;
import com.dochdonatello.hotelapp.data.remote.models.response.BaseResponse;
import com.dochdonatello.hotelapp.data.remote.models.response.Category;
import com.dochdonatello.hotelapp.data.remote.models.response.LoginResponse;
import com.dochdonatello.hotelapp.data.remote.models.response.RegisterResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ApiNetwork {

    //Login
    @POST("/api/oauth/token")
    Call<LoginResponse> login(@Body LoginRequest req);

    //Logout
    @POST("/api/oauth/register")
    Call<RegisterResponse> register(@Body LoginRequest req);

    //Category
    @POST("/api/app/category/list")
    Call<BaseResponse<List<Category>>> getAllCategories(@Body BaseRequest req, @Header("Authorization")String authHeader);
}
