package com.dochdonatello.hotelapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.dochdonatello.hotelapp.R;
import com.dochdonatello.hotelapp.data.remote.repositories.AuthRepository;
import com.dochdonatello.hotelapp.network.ApiCallbackResponse;
import com.dochdonatello.hotelapp.utils.MessageUtils;


public class RegisterActivity extends AppCompatActivity {

    private EditText etFirstName, etLastName, etUsername, etEmail, etPhone, etPassword, etConfirmPassword;
    private Button btnRegister,btnLogin;
    private AuthRepository authRepository;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initView();
    }
    private void initView()
    {
        etFirstName = findViewById(R.id.etFirstName);
        etLastName = findViewById(R.id.etLastName);
        etEmail = findViewById(R.id.etEmail);
        etPhone = findViewById(R.id.etPhone);
        etPassword = findViewById(R.id.etPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);
        etUsername = findViewById(R.id.etUsername);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);
        authRepository = new AuthRepository();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });
    }
    private void register()
    {
        String firstName = etFirstName.getText().toString().trim();
        String lastName = etLastName.getText().toString().trim();
        String username = etUsername.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String phone = etPhone.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        String confirmPassword = etConfirmPassword.getText().toString().trim();

        if (!password.equals(confirmPassword)) {
            MessageUtils.showToastMessage("Passwords do not match!", this);
            return;
        }

        authRepository.register(
                firstName,
                lastName,
                username,
                email,
                phone,
                password,
                new ApiCallbackResponse() {
                    @Override
                    public void onLoading(String message) {
                        MessageUtils.showToastMessage("Registering...", RegisterActivity.this);
                    }

                    @Override
                    public void onSuccess(Object response) {
                        MessageUtils.showToastMessage("Registered successfully!", RegisterActivity.this);
                        finish();
                    }

                    @Override
                    public void onError(String message) {
                        MessageUtils.showToastMessage("Failed: " + message, RegisterActivity.this);
                    }
                }
        );
    }

}