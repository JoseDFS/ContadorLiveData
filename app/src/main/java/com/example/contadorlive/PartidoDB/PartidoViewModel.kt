package com.example.contadorlive.PartidoDB

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PartidoViewModel(private val app: Application) : AndroidViewModel(app) {

    private val repository: PartidoRepository
    val allPartidos: LiveData<List<PartidoEntity>>

    init {
        val partidoDAO = PartidoRoomDB.getDatabase(app).partidoDao()
        repository = PartidoRepository(partidoDAO)
        allPartidos =repository.allPartidos
    }

    /**
     * Launching a new coroutine to insert the data in a non-blocking way
     */
    fun insert(partidoEntity: PartidoEntity) = viewModelScope.launch(Dispatchers.IO) {
        Log.d("Insertado",partidoEntity.toString())
        repository.insert(partidoEntity)

    }

    /*suspend fun getByfecha(fecha:String):LiveData<List<PartidoEntity>>{
        return repository.getByFecha(fecha)
    }*/
    suspend fun deleteByid(id:Int){
        repository.deleteByid(id)
    }
    fun getCount():Int {
        return repository.getCount()
    }
}