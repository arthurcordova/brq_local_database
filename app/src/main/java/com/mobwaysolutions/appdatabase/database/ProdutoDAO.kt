package com.mobwaysolutions.appdatabase.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ProdutoDAO {

    @Insert
    fun inserir(produtoEntidade: ProdutoEntidade)

    @Delete
    fun delete(produtoEntidade: ProdutoEntidade)

    @Query("SELECT * FROM produto_table ORDER BY produto_nome")
    fun buscar(): List<ProdutoEntidade>

}