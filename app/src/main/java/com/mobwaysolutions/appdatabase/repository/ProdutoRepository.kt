package com.mobwaysolutions.appdatabase.repository

import android.content.Context
import com.mobwaysolutions.appdatabase.database.AppDatabase
import com.mobwaysolutions.appdatabase.entity.ProdutoEntidade

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

    fun deletar(produtoEntidade: ProdutoEntidade) {
        AppDatabase.getInstance(context)?.getProdutoDAO()?.delete(produtoEntidade)
    }

    fun buscarComFiltro(text: String): List<ProdutoEntidade>? {
        return AppDatabase.getInstance(context)?.getProdutoDAO()?.buscarComFiltroNome(text)
    }

}