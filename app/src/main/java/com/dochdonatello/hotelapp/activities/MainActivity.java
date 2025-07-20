package com.dochdonatello.hotelapp.activities;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.dochdonatello.hotelapp.R;
import com.dochdonatello.hotelapp.data.remote.repositories.AuthRepository;
import com.dochdonatello.hotelapp.network.ApiCallbackResponse;
import com.dochdonatello.hotelapp.utils.MessageUtils;

public class MainActivity extends AuthenticatorActivity {
//    private AuthRepository authRepository;
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
    }
}