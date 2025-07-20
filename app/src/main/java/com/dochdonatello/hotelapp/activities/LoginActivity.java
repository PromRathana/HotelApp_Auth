package com.dochdonatello.hotelapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.dochdonatello.hotelapp.R;
import com.dochdonatello.hotelapp.data.local.UserLocalData;
import com.dochdonatello.hotelapp.data.remote.models.response.LoginResponse;
import com.dochdonatello.hotelapp.data.remote.repositories.AuthRepository;
import com.dochdonatello.hotelapp.network.ApiCallbackResponse;
import com.dochdonatello.hotelapp.utils.MessageUtils;

public class LoginActivity extends AppCompatActivity {
    private EditText etUsername, etPassword;
    private ProgressBar progressBar;
    private Button btnLogin;
    private AuthRepository authRepository;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initView();
    }

    private void initView()
    {
        etPassword = findViewById(R.id.etPassword);
        etUsername = findViewById(R.id.etUsername);
        progressBar = findViewById(R.id.progressbar);
        btnLogin = findViewById(R.id.btnLogin);
        authRepository = new AuthRepository();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    private void login()
    {
        String username = etUsername.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        if(username.isEmpty() || password.isEmpty())
        {
            MessageUtils.showToastMessage("Please enter your username and password",this);
             return;
        }
        authRepository.login(username, password, new ApiCallbackResponse<LoginResponse>() {
            @Override
            public void onLoading(String message) {
                progressBar.setVisibility(View.VISIBLE);
            }

            @Override
            public void onSuccess(LoginResponse response) {
                progressBar.setVisibility(View.GONE);
                UserLocalData.setUserData(response, LoginActivity.this);
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }

            @Override
            public void onError(String message) {
                progressBar.setVisibility(View.VISIBLE);
            }
        });
    }
}