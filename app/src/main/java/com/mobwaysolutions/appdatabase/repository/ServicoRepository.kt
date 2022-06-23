package com.mobwaysolutions.appdatabase.repository

import android.content.Context
import com.mobwaysolutions.appdatabase.database.AppDatabase
import com.mobwaysolutions.appdatabase.entity.ProdutoEntidade
import com.mobwaysolutions.appdatabase.entity.ServicoEntidade

class ServicoRepository(private val context: Context) {

    fun inserir(servicoEntidade: ServicoEntidade) {
        AppDatabase.getInstance(context)?.getServicoDAO()
            ?.inserir(servicoEntidade = servicoEntidade)
    }

}