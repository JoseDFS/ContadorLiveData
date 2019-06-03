package com.example.contadorlive.PartidoDB

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "partido_table")
data class PartidoEntity(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Int=0,
    @ColumnInfo(name = "EquipoA") val equipo_a: String = "N/A",
    @ColumnInfo(name = "EquipoB") val equipo_b: String= "N/A",
    @ColumnInfo(name = "PuntosA") var puntosA:Int=0,
    @ColumnInfo(name = "PuntosB") var puntosB:Int=0,
    @ColumnInfo(name = "Fecha") var fecha:String= "N/A",
    @ColumnInfo(name = "Hora") var hora:String= "N/A",
    @ColumnInfo(name = "Ganador") var ganador:String= "N/A"
)