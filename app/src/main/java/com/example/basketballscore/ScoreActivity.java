package com.example.basketballscore;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.example.basketballscore.databinding.ActivityMainBinding;
import com.example.basketballscore.databinding.ActivityScoreBinding;

public class ScoreActivity extends AppCompatActivity {
    public static final String LOCAL_SCORE_KEY = "local_score";
    public static final String VISITOR_SCORE_KEY = "visitor_score";
    private ActivityScoreBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityScoreBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int localScore = getIntent().getExtras().getInt(LOCAL_SCORE_KEY);
        int visitorScore = getIntent().getExtras().getInt(VISITOR_SCORE_KEY);

        binding.txtScore.setText(getString(R.string.local_visitor_score_format,localScore,visitorScore));

        if (localScore > visitorScore){
            binding.txtWhoWon.setText(getString(R.string.local_won));
        } else if (visitorScore > localScore) {
            binding.txtWhoWon.setText(getString(R.string.visitor_won));
        } else {
            binding.txtWhoWon.setText(getString(R.string.it_was_a_tie));
        }


    }
}