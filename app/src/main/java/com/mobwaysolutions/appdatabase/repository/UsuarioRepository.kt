package com.mobwaysolutions.appdatabase.repository

import android.content.Context
import com.mobwaysolutions.appdatabase.database.AppDatabase
import com.mobwaysolutions.appdatabase.entity.UsuarioEntidade

class UsuarioRepository(private val context: Context) {

    fun inserir(usuarioEntidade: UsuarioEntidade) {
        AppDatabase.getInstance(context)?.getUsuarioDAO()?.inserir(usuarioEntidade)
    }

    fun buscarPorId(id: Int): UsuarioEntidade? {
        return AppDatabase.getInstance(context)?.getUsuarioDAO()?.buscarPorId(id)
    }

    fun buscar(): List<UsuarioEntidade>? {
        return AppDatabase.getInstance(context)?.getUsuarioDAO()?.buscar()
    }

}
