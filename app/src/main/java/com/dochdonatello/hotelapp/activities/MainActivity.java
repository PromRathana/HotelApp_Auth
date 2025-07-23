package com.dochdonatello.hotelapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.dochdonatello.hotelapp.R;
import com.dochdonatello.hotelapp.data.local.UserLocalData;
import com.dochdonatello.hotelapp.data.remote.repositories.AuthRepository;
import com.dochdonatello.hotelapp.network.ApiCallbackResponse;
import com.dochdonatello.hotelapp.utils.MessageUtils;

public class MainActivity extends AuthenticatorActivity {
//    private AuthRepository authRepository;
    private Button btnLogout, btnOpenListCategory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initView();
        //test connection
//        authRepository = new AuthRepository();
//        authRepository.login("dinsarenkh33", "123456", new ApiCallbackResponse() {
//            @Override
//            public void onLoading(String message) {
//                MessageUtils.showToastMessage("Loading",MainActivity.this);
//            }
//
//            @Override
//            public void onSuccess(Object response) {
//                MessageUtils.showToastMessage("Success Daddy",MainActivity.this);
//            }
//
//            @Override
//            public void onError(String message) {
//                MessageUtils.showToastMessage(message,MainActivity.this);
//            }
//        });

        //btnLogout
    }
    private void initView()
    {
        this.btnLogout = findViewById(R.id.btnLogout);
        this.btnOpenListCategory = findViewById(R.id.btnListCategory);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserLocalData.removeUserData(MainActivity.this);
                onResume();
            }
        });
        btnOpenListCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,CategoryActivity.class);
                startActivity(intent);
            }
        });
    }
}