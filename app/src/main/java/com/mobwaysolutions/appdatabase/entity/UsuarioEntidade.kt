package com.mobwaysolutions.appdatabase.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UsuarioEntidade(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "usuario_id")
    var id: Int = 0,
    val email: String,
    @ColumnInfo(name = "usuario_nome")
    val nome: String
)