package com.mobwaysolutions.appdatabase.dao

import androidx.room.*
import com.mobwaysolutions.appdatabase.entity.VendasEntidade

@Dao
interface VendasDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun inserir(vendasEntidade: VendasEntidade)

    @Delete
    fun delete(vendasEntidade: VendasEntidade)

    @Query("SELECT * FROM vendasentidade ORDER BY produto_nome")
    fun buscar(): List<VendasEntidade>

}