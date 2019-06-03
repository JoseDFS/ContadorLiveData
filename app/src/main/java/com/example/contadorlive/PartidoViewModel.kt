package com.example.contadorlive

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.contadorlive.PartidoDB.PartidoEntity
import com.example.contadorlive.PartidoDB.PartidoRoomDB
import kotlinx.coroutines.launch

class PartidoViewModel(private val app: Application) : AndroidViewModel(app) {

    private val repository: PartidoRepository


    init {
        val partidoDAO = PartidoRoomDB.getDatabase(app).partidoDao()
        repository = PartidoRepository(partidoDAO)

    }

    /**
     * Launching a new coroutine to insert the data in a non-blocking way
     */
    suspend fun insert(partidoEntity: PartidoEntity) {repository.insert(partidoEntity)
    Log.d("Insertado",partidoEntity.toString())}
    fun getAllPartidos():LiveData<List<PartidoEntity>> {
        Log.d("Obtenidos","Holas")
        return repository.allPartidos()

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