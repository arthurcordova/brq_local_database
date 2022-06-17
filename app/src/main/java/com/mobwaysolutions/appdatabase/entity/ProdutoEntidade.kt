package com.mobwaysolutions.appdatabase.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "produto_table")
data class ProdutoEntidade(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "produto_id")
    var id: Int = 0,

    @ColumnInfo(name = "produto_nome")
    val nome: String,

    @ColumnInfo(name = "produto_preco")
    val preco: Double
)