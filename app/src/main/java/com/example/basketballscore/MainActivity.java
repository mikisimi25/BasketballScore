package com.example.basketballscore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.basketballscore.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    public static int count_local = 0;
    public static int count_visit = 0;
    public static final String LOCAL = "local";
    public static final String VISIT = "visit";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //Local
        binding.buttonRestLocal.setOnClickListener(v -> {
            if(count_local != 0) {
                operatorNumber(LOCAL,-1);
            }
        });
        binding.buttonSum1Local.setOnClickListener(v -> operatorNumber(LOCAL,1));
        binding.buttonSum2Local.setOnClickListener(v -> operatorNumber(LOCAL,2) );

        //Visit
        binding.buttonRestVisit.setOnClickListener(v -> {
            if(count_visit != 0) {
                operatorNumber(VISIT,-1);
            }
        });
        binding.buttonSum1Visit.setOnClickListener(v -> operatorNumber(VISIT,1) );
        binding.buttonSum2Visit.setOnClickListener(v -> operatorNumber(VISIT,2) );

        binding.reset.setOnClickListener( v -> reset() );

        binding.showResult.setOnClickListener( v -> showResult() );
    }

    private void reset() {
        count_local = count_visit = 0;
        binding.setCountLocal(count_local);
        binding.setCountVisit(count_visit);
    }

    private void operatorNumber(String team, int i) {
        switch (team) {
            case LOCAL:
                count_local += i;
                binding.setCountLocal(count_local);
                break;
            case "visit":
                count_visit += i;
                binding.setCountVisit(count_visit);
                break;
        }
    }

    private void showResult() {
        Intent intent = new Intent(this,ResultActivity.class);
        intent.putExtra(LOCAL,count_local);
        intent.putExtra(VISIT,count_visit);

        startActivity(intent);
    }

}