package com.mobwaysolutions.appdatabase.dao

import androidx.room.*
import com.mobwaysolutions.appdatabase.entity.ProdutoEntidade

@Dao
interface ProdutoDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun inserir(produtoEntidade: ProdutoEntidade)

    @Delete
    fun delete(produtoEntidade: ProdutoEntidade)

    @Query("SELECT * FROM produto_table ORDER BY produto_nome")
    fun buscar(): List<ProdutoEntidade>

    @Query("select * from produto_table where produto_id = :id")
    fun buscarPorId(id: Int): ProdutoEntidade

    @Query("select * from produto_table where produto_nome like '%' || :text || '%'")
    fun buscarComFiltroNome(text: String): List<ProdutoEntidade>
}