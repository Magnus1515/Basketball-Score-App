package com.example.basketballscore;

import androidx.lifecycle.ViewModel;

public class MainViewModel  extends ViewModel {
    public int getLocalScore() {
        return localScore;
    }

    public int getVisitScore() {
        return visitScore;
    }

    private int localScore = 0;
    private int visitScore = 0;

    public void resetScores(){
        localScore = 0;
        visitScore = 0;

    }

    public void addPointsToScore(int points, Boolean isLocal){
        if (isLocal){
            localScore += points;

        } else {
            visitScore += points;

        }
    }

    void decreaseLocal (){
        if (localScore > 0){
            localScore--;
        }


    }
    void decreseVisitor(){
        if (visitScore > 0){
            visitScore--;
        }

    }
}
