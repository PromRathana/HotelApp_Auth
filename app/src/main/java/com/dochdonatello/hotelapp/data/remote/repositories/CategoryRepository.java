package com.dochdonatello.hotelapp.data.remote.repositories;

import android.content.Context;

import com.dochdonatello.hotelapp.data.local.UserLocalData;
import com.dochdonatello.hotelapp.data.remote.models.request.BaseRequest;
import com.dochdonatello.hotelapp.data.remote.models.response.BaseResponse;
import com.dochdonatello.hotelapp.data.remote.models.response.Category;
import com.dochdonatello.hotelapp.network.ApiCallbackResponse;
import com.dochdonatello.hotelapp.network.ApiClient;
import com.dochdonatello.hotelapp.network.ApiNetwork;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryRepository {
    private final ApiNetwork apiNetwork;

    public CategoryRepository() {
        this.apiNetwork = ApiClient.getClient().create(ApiNetwork.class);
    }
    public void getAll(BaseRequest req, ApiCallbackResponse<List<Category>> callbackResponse, Context context)
    {
        try {
            callbackResponse.onLoading("Loading get all category");
            apiNetwork.getAllCategories(req, UserLocalData.getHeaderAccessToken(context)).enqueue(new Callback<BaseResponse<List<Category>>>() {
                @Override
                public void onResponse(Call<BaseResponse<List<Category>>> call, Response<BaseResponse<List<Category>>> response) {
                    if (response.isSuccessful() && response.body() != null) {
                        callbackResponse.onSuccess(response.body().getData());
                    } else {
                        callbackResponse.onError("Get all categories error!");
                    }
                }

                @Override
                public void onFailure(Call<BaseResponse<List<Category>>> call, Throwable t) {
                    callbackResponse.onError("Error call to server api : "+t.getMessage());
                }
            });
        }
        catch (Throwable e)
        {
            callbackResponse.onError("General Error : " +e.getMessage());
        }
    }
}
