package com.example.basketballscore;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.basketballscore.databinding.ActivityMainBinding;
import com.example.basketballscore.databinding.ActivityResultBinding;

public class ResultActivity extends AppCompatActivity {

    public static String count = "";
    public static String result_value_number = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityResultBinding binding = ActivityResultBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Bundle extras = getIntent().getExtras();
        int count_local = extras.getInt(MainActivity.LOCAL);
        int count_visit = extras.getInt(MainActivity.VISIT);

        count = count_local + " - " + count_visit;

        if( count_local == count_visit ) {
            result_value_number = getString(R.string.tie);
        } else if( count_local > count_visit ) {
            result_value_number = getString(R.string.win_local);
        } else {
            result_value_number = getString(R.string.win_visit);
        }

        binding.setCount(count);
        binding.setResultValueNumber(result_value_number);

    }
}