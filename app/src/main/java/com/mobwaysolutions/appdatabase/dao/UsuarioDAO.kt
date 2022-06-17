package com.mobwaysolutions.appdatabase.dao

import androidx.room.*
import com.mobwaysolutions.appdatabase.entity.UsuarioEntidade

@Dao
interface UsuarioDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun inserir(usuarioEntidade: UsuarioEntidade)

    @Query("select * from usuarioentidade where id = :id")
    fun buscarPorId(id: Int): UsuarioEntidade

    @Query("select * from usuarioentidade")
    fun buscar(): List<UsuarioEntidade>

}