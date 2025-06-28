package com.example.mobieapphnd.ui.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Kiểm tra xem user đã đăng nhập chưa
        SharedPreferences prefs = getSharedPreferences("user_prefs", MODE_PRIVATE);
        boolean isLoggedIn = prefs.getBoolean("is_logged_in", false);

        Intent intent;
        if (isLoggedIn) {
            // Nếu đã đăng nhập, chuyển đến HomeActivity
            intent = new Intent(this, HomeActivity.class);
        } else {
            // Nếu chưa đăng nhập, chuyển đến LoginActivity
            intent = new Intent(this, LoginActivity.class);
        }

        startActivity(intent);
        finish();
    }
}