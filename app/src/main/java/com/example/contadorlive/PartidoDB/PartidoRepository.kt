package com.example.contadorlive.PartidoDB

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.contadorlive.PartidoDB.PartidoDAO
import com.example.contadorlive.PartidoDB.PartidoEntity

class PartidoRepository(private var partidoDAO: PartidoDAO) {

    val allPartidos: LiveData<List<PartidoEntity>> = partidoDAO.getPartidos()

    fun getCount():Int = partidoDAO.getCount()
    @WorkerThread
    suspend fun insert(partidoEntity: PartidoEntity) {
        partidoDAO.insert(partidoEntity)
    }
    /*@WorkerThread
    suspend fun getByFecha(fecha:String):LiveData<List<PartidoEntity>> {
       return partidoDAO.getByFecha(fecha)
    }*/
    @WorkerThread
    suspend fun deleteByid(id:Int){
        partidoDAO.deleteByid(id)
    }


}