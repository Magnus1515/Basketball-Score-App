package com.example.basketballscore;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.basketballscore.databinding.ActivityMainBinding;
import com.example.basketballscore.databinding.ActivityScoreBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setupButtons();

        viewModel =  new ViewModelProvider(this).get(MainViewModel.class);
    }


    private void setupButtons(){
        //local buttons
        binding.btnLocalMinus1.setOnClickListener(view -> {
            viewModel.decreaseLocal();
            binding.txtScoreLocal.setText(String.valueOf(viewModel.getLocalScore()));

        });
        binding.btnLocalSum1.setOnClickListener(view -> {
            addPointsToScore(1,true);
        });
        binding.btnLocalSum2.setOnClickListener(view -> {
            addPointsToScore(2,true);
        });

        //Visitor Buttons
        binding.btnVisitanteMinus1.setOnClickListener(view -> {
            viewModel.decreseVisitor();
            binding.txtScoreVisitante.setText(String.valueOf(viewModel.getVisitScore()));
        });

        binding.btnVisitanteSum2.setOnClickListener(view -> {
            addPointsToScore(2,false);
        });
        binding.btnVisitanteSum1.setOnClickListener(view -> {
            addPointsToScore(1,false);
        });

        // Next button
        binding.btnNext.setOnClickListener(view ->  {
                startScoreActivity();
        });

        binding.btnReset.setOnClickListener(view -> {
            resetScores();
        });

    }
    private void resetScores(){
        viewModel.resetScores();
        binding.txtScoreLocal.setText(String.valueOf(viewModel.getLocalScore()));
        binding.txtScoreVisitante.setText(String.valueOf(viewModel.getVisitScore()));
    }

    private void addPointsToScore(int points, Boolean isLocal){
        viewModel.addPointsToScore(points,isLocal);
        if (isLocal){

            binding.txtScoreLocal.setText(String.valueOf(viewModel.getLocalScore()));
        } else {

            binding.txtScoreVisitante.setText(String.valueOf(viewModel.getVisitScore()));
        }
    }
    private void startScoreActivity(){
        Intent intent = new Intent(this, ScoreActivity.class);
        intent.putExtra(ScoreActivity.LOCAL_SCORE_KEY, viewModel.getLocalScore());
        intent.putExtra(ScoreActivity.VISITOR_SCORE_KEY,viewModel.getVisitScore());
        startActivity(intent);
    }

}