package com.mobwaysolutions.appdatabase.entity

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "servico_table")
data class ServicoEntidade(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "servico_id")
    val id: Int,
    @ColumnInfo(name = "servico_nome")
    val nome: String,
    @Embedded
    val usuario: UsuarioEntidade,
    @Embedded
    val endereco: EnderecoDTO
)