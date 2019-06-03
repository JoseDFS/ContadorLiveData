package com.example.contadorlive

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.contadorlive.PartidoDB.PartidoEntity
import com.example.contadorlive.databinding.ActivityNewPartidoBinding
import kotlinx.android.synthetic.main.activity_guardados.*
import kotlinx.android.synthetic.main.activity_new_partido.*




class NewPartidoActivity : AppCompatActivity() {

    lateinit var viewModel:PartidoViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_partido)
        val scoreViewModel= ViewModelProviders.of(this)
            .get(ScoreViewModel::class.java)

        DataBindingUtil.setContentView<ActivityNewPartidoBinding>(
            this,R.layout.activity_new_partido
        ).apply {
            this.setLifecycleOwner(this@NewPartidoActivity)
            this.score= scoreViewModel
        }
        viewModel = ViewModelProviders.of(this).get(PartidoViewModel::class.java)
        bt_guardar.setOnClickListener {
            var partidoEntity = PartidoEntity(1,et_1.text.toString(),et_2.text.toString()
                ,tv_score_team_a.text.toString().toInt(),tv_score_team_b.text.toString().toInt(),
                    et_fecha.text.toString(),ganador(tv_score_team_a.text.toString(),tv_score_team_b.text.toString()))
            suspend { viewModel.insert(partidoEntity) }
            Log.d("InsertadoEnDB",viewModel.getAllPartidos().toString())
            Log.d("Hey",partidoEntity.toString())
            finish()
        }


    }

    fun ganador(scoreA:String,scoreB:String):String{
        if(scoreA.toInt() > scoreB.toInt()){
            return tv_score_team_a.text.toString()
        }
        else return tv_score_team_b.text.toString()
    }


}
