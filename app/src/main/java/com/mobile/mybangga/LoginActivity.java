package com.mobile.mybangga;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.Toolbar;

import com.mobile.mybangga.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {
    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
//        getSupportActionBar().hide();


        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_action_bar_layout);



//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION, WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
//        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        ImageButton imageButton = (ImageButton) findViewById(R.id.notifikasi);
        imageButton.setVisibility(View.INVISIBLE);

//        getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(R.drawable.temp1));
//        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

    }

}