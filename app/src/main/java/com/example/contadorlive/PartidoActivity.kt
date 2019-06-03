package com.example.contadorlive

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_partido.*

class PartidoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_partido)

        val mIntent = intent
        if (mIntent != null) {


            tv_vs.text = mIntent.getStringExtra("A") + " vs " + mIntent.getStringExtra("B")
            tv_fecha.text =tv_fecha.text.toString() + mIntent.getStringExtra("FECHA")
            tv_hora.text =tv_hora.text.toString() + mIntent.getStringExtra("HORA")
            tv_scoreA.text = mIntent.getStringExtra("PuntosA")
            tv_scoreB.text = mIntent.getStringExtra("PuntosB")
            tv_teamA.text =mIntent.getStringExtra("A")
            tv_teamB.text =mIntent.getStringExtra("B")
            tv_winner.text =tv_winner.text.toString() + " " + mIntent.getStringExtra("GANADOR")

        }
    }
}
