package com.example.contadorlive.PartidoDB

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PartidoDAO{
    @Query("SELECT * FROM partido_table ORDER BY id ASC")
    fun getPartidos(): LiveData<List<PartidoEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(partidoEntity: PartidoEntity)

    @Query("DELETE FROM partido_table")
    suspend fun deleteAllPartidos()

    @Query("DELETE FROM partido_table WHERE id = :id")
    suspend fun deleteByid(id:Int)

    @Query("SELECT COUNT(id) FROM partido_table")
    fun getCount():Int

   /* @Query("SELECT * FROM partido_table WHERE fecha=:fecha")
    suspend fun getByFecha(fecha:String): LiveData<List<PartidoEntity>>*/

}