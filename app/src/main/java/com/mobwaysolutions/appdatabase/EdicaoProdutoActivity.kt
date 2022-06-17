package com.mobwaysolutions.appdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputLayout
import com.mobwaysolutions.appdatabase.entity.ProdutoEntidade
import com.mobwaysolutions.appdatabase.repository.ProdutoRepository

class EdicaoProdutoActivity : AppCompatActivity() {
    private lateinit var tilProdutoNome: TextInputLayout
    private lateinit var tilProdutoPreco: TextInputLayout
    private lateinit var tvTitulo: TextView
    private lateinit var buttonSave: Button
    private lateinit var buttonDelete: Button

    private val produtoRepository = ProdutoRepository(this)

    private var produtoId: Int? = null
    private var isEditMode = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edicao_produto)

        initComponents()


        produtoId = intent.getIntExtra("produto_id", 0)
        isEditMode = if (produtoId!! > 0) true else false

        if (isEditMode) {
            tvTitulo.text = "Editar um produto"
            buttonSave.text = "Alterar"
            buttonDelete.visibility = View.VISIBLE

            val produtoSelecionado = produtoRepository.buscarPorId(produtoId!!)
            produtoSelecionado?.let { prod ->
                tilProdutoNome.editText?.setText(prod.nome)
                tilProdutoPreco.editText?.setText(prod.preco.toString())

                buttonDelete.setOnClickListener {
                    produtoRepository.deletar(prod)
                    finish()
                }
            }
        }

        buttonSave.setOnClickListener { saveToLocalDb() }

    }

    private fun initComponents() {
        tilProdutoNome = findViewById(R.id.tilProdutoNome)
        tilProdutoPreco = findViewById(R.id.tilProdutoPreco)
        buttonSave = findViewById(R.id.bSave)
        buttonDelete = findViewById(R.id.bDelete)
        tvTitulo = findViewById(R.id.tvTitulo)
    }

    private fun saveToLocalDb() {
        val nomeDaTela = tilProdutoNome.editText?.text.toString()
        val precoDaTela = tilProdutoPreco.editText?.text.toString()
        if (nomeDaTela.isNotEmpty()) {
            tilProdutoNome.error = null
            tilProdutoPreco.error = null

            val produtoEntidade: ProdutoEntidade
            if (isEditMode) {
                produtoEntidade =
                    ProdutoEntidade(
                        id = produtoId!!,
                        nome = nomeDaTela,
                        preco = (precoDaTela.toDoubleOrNull() ?: 0.0)
                    )
            } else {
                produtoEntidade =
                    ProdutoEntidade(
                        nome = nomeDaTela,
                        preco = (precoDaTela.toDoubleOrNull() ?: 0.0)
                    )
            }
            produtoRepository.inserir(produtoEntidade)

            finish()

        } else {
            tilProdutoNome.error = "Nome não pode estar em branco"
            tilProdutoPreco.error = "Nome não pode estar em branco"
        }
    }
}