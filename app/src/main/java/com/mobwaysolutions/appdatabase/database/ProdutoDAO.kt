package com.mobwaysolutions.appdatabase.database

import androidx.room.*

@Dao
interface ProdutoDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun inserir(produtoEntidade: ProdutoEntidade)

    @Delete
    fun delete(produtoEntidade: ProdutoEntidade)

    @Query("SELECT * FROM produto_table ORDER BY produto_nome")
    fun buscar(): List<ProdutoEntidade>

    @Query("select * from produto_table where produto_id = :id")
    fun buscarPorId(id: Int) : ProdutoEntidade
}