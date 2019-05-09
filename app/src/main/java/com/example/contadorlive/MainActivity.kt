package com.example.contadorlive

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.aldana.ejemplo14.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var scoreViewModel = ScoreViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        binding.score = scoreViewModel
        binding.lifecycleOwner = this
        setContentView(binding.root)


        /* scoreViewModel = ViewModelProviders.of(this).get(ScoreViewModel::class.java)

         displayScore(
             tv_score_team_a,
             scoreViewModel.scoreTeamA
         )

         displayScore(
             tv_score_team_b,
             scoreViewModel.scoreTeamB
         )
 */
        // TODO: El ViewModel es restaurado si ya existía, si no, se crea uno nuevo.
        // TODO: Recuerde que el ViewModel solo sobrevive a cambios de configuración y no a la destrucción de la aplicación

    }


    // TODO: Accediendo y modificando datos almacenados en el ViewModel según el método utilizado

    fun addOneTeamA(v: View) {
        val s = scoreViewModel.scoreTeamA.toInt() + 1
        scoreViewModel.scoreTeamA = s.toString()
        Log.d("hey:",scoreViewModel.scoreTeamA)
    }

    fun addOneTeamB(v: View) {
        val s = scoreViewModel.scoreTeamB.toInt() + 1
        scoreViewModel.scoreTeamB = s.toString()
    }

    fun addTwoTeamA(v: View) {
        val s = scoreViewModel.scoreTeamA.toInt() + 2
        scoreViewModel.scoreTeamA = s.toString()
    }

    fun addTwoTeamB(v: View) {
        val s = scoreViewModel.scoreTeamB.toInt() + 2
        scoreViewModel.scoreTeamB = s.toString()
    }

    fun addThreeTeamA(v: View) {
        val s = scoreViewModel.scoreTeamA.toInt() + 3
        scoreViewModel.scoreTeamA = s.toString()
    }

    fun addThreeTeamB(v: View) {
        val s = scoreViewModel.scoreTeamB.toInt() + 3
        scoreViewModel.scoreTeamB = s.toString()
    }

    fun resetScores(v: View) {
        scoreViewModel.scoreTeamA = "0"
        scoreViewModel.scoreTeamB = "0"


    } // TODO: Limpiando datos

    fun displayScore(v: TextView, score: Int) {
        v.text = score.toString()
    }

}
