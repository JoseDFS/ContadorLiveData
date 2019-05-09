package com.example.contadorlive

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.contadorlive.ScoreViewModel
import com.example.contadorlive.databinding.ActivityMainBinding

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         val scoreViewModel=ViewModelProviders.of(this)
                .get(ScoreViewModel::class.java)

        DataBindingUtil.setContentView<ActivityMainBinding>(
                this,R.layout.activity_main
        ).apply {
            this.setLifecycleOwner(this@MainActivity)
            this.score = scoreViewModel
        }

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

     // TODO: Limpiando datos

    fun displayScore(v: TextView, score: Int) {
        v.text = score.toString()
    }

}
