package com.example.contadorlive.PartidoDB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database (entities = [PartidoEntity::class],version = 1,exportSchema = false)
abstract class PartidoRoomDB:RoomDatabase(){

    abstract fun partidoDao():PartidoDAO

    companion object{
        @Volatile
        private var INSTANCE: PartidoRoomDB?=null

        fun getDatabase(context:Context):PartidoRoomDB {
            if (INSTANCE != null) {
                return INSTANCE!!
            }
            else{
                synchronized(this) {
                    val instance = Room
                        .databaseBuilder(context, PartidoRoomDB::class.java, "Partido_Database")
                        .build()
                    INSTANCE=instance
                    return instance
                }
            }
        }
    }
}