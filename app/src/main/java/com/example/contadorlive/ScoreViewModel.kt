package com.example.contadorlive

import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class ScoreViewModel: ViewModel() {
    private val _scoreTeamA= MutableLiveData<Int>()
    val scoreTeamA :LiveData<Int>
        get() = _scoreTeamA


    init {
        _scoreTeamA.value=0
    }
    var scoreTeamB:Int=0

    fun addOneTeamA() {
        _scoreTeamA.value = _scoreTeamA.value?.plus(1)


        Log.d("hey:", scoreTeamA.value.toString())
    }

    fun addOneTeamB() {
        _scoreTeamA.value = _scoreTeamA.value?.plus(1)

    }

    fun addTwoTeamA() {
        _scoreTeamA.value = _scoreTeamA.value?.plus(2)
    }

    fun addTwoTeamB() {
        _scoreTeamA.value = _scoreTeamA.value?.plus(2)
    }

    fun addThreeTeamA() {
        _scoreTeamA.value = _scoreTeamA.value?.plus(3)
    }

    fun addThreeTeamB() {
        _scoreTeamA.value = _scoreTeamA.value?.plus(3)
    }

    fun resetScores() {
        _scoreTeamA.value = 0
        scoreTeamB=0


    }
}