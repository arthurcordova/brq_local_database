package com.mobwaysolutions.appdatabase.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UsuarioEntidade(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    val email: String,
    val nome: String
)