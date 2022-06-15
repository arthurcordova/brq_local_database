package com.mobwaysolutions.appdatabase.database

import android.content.Context

class ProdutoRepository(private val context: Context) {

    fun inserir(produtoEntidade: ProdutoEntidade) {
        AppDatabase.getInstance(context)?.getProdutoDAO()?.inserir(produtoEntidade)
    }

    fun buscar(): List<ProdutoEntidade>? {
        return AppDatabase.getInstance(context)?.getProdutoDAO()?.buscar()
    }

    fun buscarPorId(id: Int): ProdutoEntidade? {
        return AppDatabase.getInstance(context)?.getProdutoDAO()?.buscarPorId(id)
    }

}