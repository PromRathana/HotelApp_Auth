package com.dochdonatello.hotelapp.utils;

import android.content.Context;
import android.widget.Toast;

import com.dochdonatello.hotelapp.activities.MainActivity;

public class MessageUtils {
    public static void showToastMessage(String message, Context context)
    {
        Toast.makeText(context,message,Toast.LENGTH_LONG).show();

    }
}
