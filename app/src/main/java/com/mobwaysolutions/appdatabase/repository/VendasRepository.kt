package com.mobwaysolutions.appdatabase.repository

import android.content.Context
import com.mobwaysolutions.appdatabase.database.AppDatabase
import com.mobwaysolutions.appdatabase.entity.VendasEntidade

class VendasRepository(private val context: Context) {

    fun inserir(vendasEntidade: VendasEntidade) {
        AppDatabase.getInstance(context)?.getVendasDAO()?.inserir(vendasEntidade)
    }

    fun buscar(): List<VendasEntidade>? {
        return AppDatabase.getInstance(context)?.getVendasDAO()?.buscar()
    }

    fun deletar(vendasEntidade: VendasEntidade) {
        AppDatabase.getInstance(context)?.getVendasDAO()?.delete(vendasEntidade)
    }

}