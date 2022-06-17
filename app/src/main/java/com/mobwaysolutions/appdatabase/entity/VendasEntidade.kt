package com.mobwaysolutions.appdatabase.entity

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class VendasEntidade(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "vendas_id")
    var id: Int = 0,
    @Embedded
    val usuario: UsuarioEntidade,
    @Embedded
    val produto: ProdutoEntidade
)