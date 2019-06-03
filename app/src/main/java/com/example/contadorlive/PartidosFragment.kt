package com.example.contadorlive

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.contadorlive.PartidoDB.PartidoEntity
import kotlinx.android.synthetic.main.activity_guardados.*
import kotlinx.android.synthetic.main.activity_guardados.view.*

class PartidosFragment : Fragment() {

    lateinit var Radapter: AdapterPartido
    lateinit var viewModel: PartidoViewModel

    var click: OnFragmentInteractionListener? = null
    var flag: Boolean = true

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.activity_guardados, container, false)
        viewModel = ViewModelProviders.of(this).get(PartidoViewModel::class.java)

        if (savedInstanceState != null) flag = savedInstanceState.getBoolean("FLAG")

        initRecyclerView(resources.configuration.orientation, view)
        return view
    }

    fun initRecyclerView(orientation: Int, container: View) {
        val linearLayoutManager = LinearLayoutManager(this.context)
        Radapter = AdapterPartido(ArrayList(), { partido: PartidoEntity -> click?.partidoItemClicked(partido) })

        container.rv_list_partidos.adapter = Radapter
        if (flag) {
            viewModel.getAllPartidos().observe(this, Observer { boooks ->
                boooks?.let { Radapter.updateList(it) }
                Log.d("Actualizando","Actualizando")
            })
        } else {
            /*gameViewModel.favoriteBooks.observe(this, Observer { boooks ->
                boooks?.let{bookadapter.setWords(it)}
            })*/
        }

        container.rv_list_partidos.apply {
            setHasFixedSize(true)
            layoutManager = linearLayoutManager
        }
    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean("FLAG", flag)
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            click = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        click = null
    }


    interface OnFragmentInteractionListener {
        fun partidoItemClicked(item: PartidoEntity)


    }


    companion object {
        fun newInstance(flag: Boolean): PartidosFragment {
            val newFragment = PartidosFragment()
            newFragment.flag = flag
            return newFragment
        }
    }
}
/*

private fun bind(){
    Radapter= AdapterPartido(ArrayList(),{partido: PartidoEntity -> partidoItemClicked(partido) })
    viewModel= ViewModelProviders.of(this).get(PartidoViewModel::class.java)
    rv_list_partidos.apply {
        adapter=this@PartidosFragment.Radapter
        layoutManager= LinearLayoutManager(this@PartidosFragment)
    }
    Log.d("En Bind","Holis")
    viewModel.getAllPartidos().observe(this, Observer {
        Radapter.updateList(it)
    })
    /*btn_repo.setOnClickListener {
        viewModel.retrieveRepo(et_repo.text.toString())
    }*/
}

private fun partidoItemClicked(item: PartidoEntity) {
    /*if (twoPane) {
        mainContentFragment = MainContentFragment.newInstance(item)
        supportFragmentManager.beginTransaction().replace(R.id.fragment_content, mainContentFragment).commit()
    } else {*/
        val extras = Bundle()
        extras.putString("A", item.equipo_a)
        extras.putString("B", item.equipo_b)
        extras.putString("FECHA", item.fecha)
        extras.putString("PuntosA", item.puntosA.toString())
        extras.putString("PuntosA", item.puntosA.toString())

        startActivity(Intent(this, PartidoActivity::class.java).putExtras(extras))
    //}


}
}
*/