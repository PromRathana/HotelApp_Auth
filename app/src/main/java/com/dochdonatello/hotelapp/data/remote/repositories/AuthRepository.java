package com.dochdonatello.hotelapp.data.remote.repositories;

import com.dochdonatello.hotelapp.data.remote.models.request.LoginRequest;
import com.dochdonatello.hotelapp.data.remote.models.response.LoginResponse;
import com.dochdonatello.hotelapp.network.ApiCallbackResponse;
import com.dochdonatello.hotelapp.network.ApiClient;
import com.dochdonatello.hotelapp.network.ApiNetwork;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AuthRepository {
    private final ApiNetwork apiNetwork;
    public AuthRepository ()
    {
        apiNetwork = ApiClient.getClient().create(ApiNetwork.class);
    }

    public void login (String username, String password, ApiCallbackResponse<LoginResponse> callbackResponse)
    {
        callbackResponse.onLoading("Loading");
        try {
            LoginRequest loginRequest = new LoginRequest();
            loginRequest.setPhoneNumber(username);
            loginRequest.setPassword(password);
            apiNetwork.login(loginRequest).enqueue(new Callback<LoginResponse>() {
                @Override
                public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                    if (response.isSuccessful() && response.body() != null) {
                        callbackResponse.onSuccess(response.body());
                    } else {
                        callbackResponse.onError("Your username and password are incorrect!");
                    }
                }

                @Override
                public void onFailure(Call<LoginResponse> call, Throwable t) {
                    callbackResponse.onError("Internal Server" + t.getMessage());
                }
            });
        }
        catch (Throwable e)
        {
            callbackResponse.onError("General Error" +e.getMessage());
        }
    }
}
