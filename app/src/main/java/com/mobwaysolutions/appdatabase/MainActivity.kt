package com.mobwaysolutions.appdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputLayout
import com.mobwaysolutions.appdatabase.adapter.ProdutoAdapter
import com.mobwaysolutions.appdatabase.database.ProdutoEntidade
import com.mobwaysolutions.appdatabase.database.ProdutoRepository

class MainActivity : AppCompatActivity() {

    private lateinit var tilProdutoNome: TextInputLayout
    private lateinit var buttonSave: Button
    private lateinit var rvListaProdutos: RecyclerView
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
        rvListaProdutos = findViewById(R.id.rvListaProdutos)
    }

    private fun saveToLocalDb() {
        val nomeDaTela = tilProdutoNome.editText?.text.toString()
        if (nomeDaTela.isNotEmpty()) {
            tilProdutoNome.error = null
            val produtoEntidade = ProdutoEntidade(nome = nomeDaTela, preco = 19.90)
            produtoRepository.inserir(produtoEntidade)
        } else {
            tilProdutoNome.error = "Nome não pode estar em branco"
        }
    }

    private fun buscarTodosOsDadosDoBanco() {
        val listaDeprodutos = produtoRepository.buscar()

        listaDeprodutos?.let {
            startRecyclerView(it)
        }

    }

    private fun startRecyclerView(listaDeProdutos: List<ProdutoEntidade>) {
        rvListaProdutos.adapter = ProdutoAdapter(listaDeProdutos)
        rvListaProdutos.layoutManager = LinearLayoutManager(this)
    }

}