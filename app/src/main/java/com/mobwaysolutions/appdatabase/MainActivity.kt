package com.mobwaysolutions.appdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.textfield.TextInputLayout
import com.mobwaysolutions.appdatabase.database.ProdutoEntidade
import com.mobwaysolutions.appdatabase.database.ProdutoRepository

class MainActivity : AppCompatActivity() {

    private lateinit var tilProdutoNome: TextInputLayout
    private lateinit var buttonSave: Button
    private val produtoRepository = ProdutoRepository(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initComponents()
        buscarTodosOsDadosDoBanco()
        buttonSave.setOnClickListener { saveToLocalDb() }
    }

    private fun initComponents() {
        tilProdutoNome = findViewById(R.id.tilProdutoNome)
        buttonSave = findViewById(R.id.bSave)
    }

    private fun saveToLocalDb() {
        val nomeDaTela = tilProdutoNome.editText?.text.toString()
        if (nomeDaTela.isNotEmpty()) {
            tilProdutoNome.error = null
            val produtoEntidade = ProdutoEntidade(nome = nomeDaTela)
            produtoRepository.inserir(produtoEntidade)
        } else {
            tilProdutoNome.error = "Nome não pode estar em branco"
        }
    }

    private fun buscarTodosOsDadosDoBanco() {
        val listaDeprodutos = produtoRepository.buscar()

        listaDeprodutos?.forEach {
            println( "${it.nome} --- ID --- ${it.id}" )
        }
    }
}