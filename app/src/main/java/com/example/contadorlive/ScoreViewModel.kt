package com.example.contadorlive

import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class ScoreViewModel: ViewModel() {
    private val _scoreTeamA= MutableLiveData<String>()
    val scoreTeamA :LiveData<String>
        get() = _scoreTeamA


    init {
        _scoreTeamA.value = "0"
    }
    var scoreTeamB:Int=0

    fun addOneTeamA() {
        _scoreTeamA.value = _scoreTeamA.value?.toInt()?.plus(1).toString()


        Log.d("hey:", scoreTeamA.value.toString())
    }

    fun addOneTeamB() {
        _scoreTeamA.value = _scoreTeamA.value?.toInt()?.plus(1).toString()

    }

    fun addTwoTeamA() {
        _scoreTeamA.value = _scoreTeamA.value?.toInt()?.plus(2).toString()
    }

    fun addTwoTeamB() {
        _scoreTeamA.value = _scoreTeamA.value?.toInt()?.plus(2).toString()
    }

    fun addThreeTeamA() {
        _scoreTeamA.value = _scoreTeamA.value?.toInt()?.plus(3).toString()
    }

    fun addThreeTeamB() {
        _scoreTeamA.value = _scoreTeamA.value?.toInt()?.plus(3).toString()
    }

    fun resetScores() {
        _scoreTeamA.value = "0"
        scoreTeamB=0


    }
}