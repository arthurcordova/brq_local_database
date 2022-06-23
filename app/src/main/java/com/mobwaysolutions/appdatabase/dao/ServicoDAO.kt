package com.mobwaysolutions.appdatabase.dao

import androidx.room.*
import com.mobwaysolutions.appdatabase.entity.ProdutoEntidade
import com.mobwaysolutions.appdatabase.entity.ServicoEntidade

@Dao
interface ServicoDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun inserir(servicoEntidade: ServicoEntidade)

    @Delete
    fun delete(servicoEntidade: ServicoEntidade)

    @Query("SELECT * FROM servico_table ORDER BY servico_nome")
    fun buscar(): List<ServicoEntidade>

}