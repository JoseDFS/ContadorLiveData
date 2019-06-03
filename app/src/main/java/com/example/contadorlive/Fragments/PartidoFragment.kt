package com.example.contadorlive.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.contadorlive.PartidoDB.PartidoEntity
import com.example.contadorlive.PartidoDB.PartidoViewModel
import com.example.contadorlive.R
import kotlinx.android.synthetic.main.activity_partido.view.*

class PartidoFragment : Fragment() {

     var partido = PartidoEntity()
    lateinit var viewModel: PartidoViewModel

    companion object{
        fun newInstance (partido: PartidoEntity): PartidoFragment {
            val newFragment = PartidoFragment()
            newFragment.partido = partido
            return  newFragment
        }
    }



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.activity_partido,container,false)

        viewModel = ViewModelProviders.of(this).get(PartidoViewModel::class.java)


        bindData(view)
        return view
    }




    fun bindData(view: View) {
        view.tv_vs.text = partido.equipo_a + " vs " + partido.equipo_b
        view.tv_fecha.text = partido.fecha
        view.tv_hora.text =  partido.hora
        view.tv_scoreA.text = partido.puntosA.toString()
        view.tv_scoreB.text = partido.puntosB.toString()
        view.tv_teamA.text =partido.equipo_a + ":"
        view.tv_teamB.text =partido.equipo_b + ":"
        view.tv_winner.text = partido.ganador
    }

}