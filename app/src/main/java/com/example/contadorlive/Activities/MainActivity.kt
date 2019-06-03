package com.example.contadorlive.Activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders

import com.example.contadorlive.PartidoDB.PartidoEntity
import com.example.contadorlive.Fragments.PartidoFragment
import com.example.contadorlive.PartidoDB.PartidoViewModel
import com.example.contadorlive.Fragments.PartidosFragment
import com.example.contadorlive.Fragments.PartidosFragment.*
import com.example.contadorlive.R


import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), OnFragmentInteractionListener {


    private lateinit var viewModel: PartidoViewModel
    private lateinit var fragment: PartidosFragment
    private lateinit var mainContentFragment : PartidoFragment
    private val newBookActivityRequestCode = 1

    var twoPane = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(PartidoViewModel::class.java)
        fragment = PartidosFragment.newInstance(true)
        val resource = R.id.frameLayoutMain
        changeFragment(resource, fragment)

        if (fragment_content != null) {
            twoPane = true
            mainContentFragment = PartidoFragment.newInstance(PartidoEntity())
            supportFragmentManager.beginTransaction().replace(R.id.fragment_content, mainContentFragment).commit()
        }

        buttonN.setOnClickListener {
            val intent = Intent(this@MainActivity, NewPartidoActivity::class.java)
            startActivityForResult(intent, newBookActivityRequestCode)
        }
    }


    override fun partidoItemClicked(item: PartidoEntity) {
        if(twoPane){
            mainContentFragment = PartidoFragment.newInstance(item)
            supportFragmentManager.beginTransaction().replace(R.id.fragment_content, mainContentFragment).commit()
        }
        else {
            val extras = Bundle()
            extras.putString("A", item.equipo_a)
            extras.putString("B", item.equipo_b)
            extras.putString("FECHA", item.fecha)
            extras.putString("PuntosA", item.puntosA.toString())
            extras.putString("PuntosB", item.puntosB.toString())
            extras.putString("GANADOR", item.ganador.toString())
            extras.putString("HORA", item.hora.toString())

            startActivity(Intent(this, PartidoActivity::class.java).putExtras(extras))
        }
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







    private fun changeFragment(id: Int, frag: Fragment){ supportFragmentManager.beginTransaction().replace(id, frag).commit() }

}


