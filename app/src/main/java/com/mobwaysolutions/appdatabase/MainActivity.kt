package com.mobwaysolutions.appdatabase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.TextInputLayout
import com.mobwaysolutions.appdatabase.adapter.ProdutoAdapter
import com.mobwaysolutions.appdatabase.entity.ProdutoEntidade
import com.mobwaysolutions.appdatabase.entity.VendasEntidade
import com.mobwaysolutions.appdatabase.repository.ProdutoRepository
import com.mobwaysolutions.appdatabase.repository.UsuarioRepository
import com.mobwaysolutions.appdatabase.repository.VendasRepository

class MainActivity : AppCompatActivity() {

    private lateinit var rvListaProdutos: RecyclerView
    private lateinit var fabAdd: FloatingActionButton
    private lateinit var buttonPesquisa: Button
    private lateinit var tilPesquisa: TextInputLayout

    private val produtoRepository = ProdutoRepository(this)
    private val usuarioRepository = UsuarioRepository(this)
    private val vendasRepository = VendasRepository(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initComponents()
        fabAdd.setOnClickListener {
            Intent(this, EdicaoProdutoActivity::class.java).let {
                startActivity(it)
            }
        }

        buttonPesquisa.setOnClickListener {
            val textPesquisa = tilPesquisa.editText?.text.toString()
            if (textPesquisa.isNotEmpty()) {
                val novaListaFiltrada = produtoRepository.buscarComFiltro(textPesquisa)
                val adapter = rvListaProdutos.adapter as ProdutoAdapter
                novaListaFiltrada?.let {
                    adapter.refresh(it)
                }
            } else {
                buscarTodosOsDadosDoBanco()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        buscarTodosOsDadosDoBanco()
    }

    private fun initComponents() {
        rvListaProdutos = findViewById(R.id.rvListaProdutos)
        fabAdd = findViewById(R.id.fabAdd)
        tilPesquisa = findViewById(R.id.tilPesquisa)
        buttonPesquisa = findViewById(R.id.bPesquisa)
    }

    private fun buscarTodosOsDadosDoBanco() {
        val listaDeprodutos = produtoRepository.buscar()

        listaDeprodutos?.let {
            startRecyclerView(it)
        }
    }

    private fun startRecyclerView(listaDeProdutos: List<ProdutoEntidade>) {
        rvListaProdutos.adapter =
            ProdutoAdapter(listaDeProdutos.toMutableList(), onClick = { produto ->
                Intent(this, EdicaoProdutoActivity::class.java).let {
                    it.putExtra("produto_id", produto.id)
                    startActivity(it)
                }
            }, onClickAddProduct = { produto ->
                salvarVenda(produto)
            })
        rvListaProdutos.layoutManager = LinearLayoutManager(this)
    }


    fun salvarVenda(produtoEntidade: ProdutoEntidade) {
        val usuario = usuarioRepository.buscar()?.first()
        usuario?.let { user ->
            val vendasEntidade = VendasEntidade(produto = produtoEntidade,
                usuario = user
            )
            vendasRepository.inserir(vendasEntidade)
        }
    }



}