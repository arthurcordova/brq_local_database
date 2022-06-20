package com.mobwaysolutions.appdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mobwaysolutions.appdatabase.entity.VendasEntidade
import com.mobwaysolutions.appdatabase.repository.UsuarioRepository
import com.mobwaysolutions.appdatabase.repository.VendasRepository

class CarrinhoActivity : AppCompatActivity() {

    lateinit var tvTitulo: TextView
    lateinit var rvProdutos: RecyclerView

    private val usuarioRepository = UsuarioRepository(this)
    private val vendasRepository = VendasRepository(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carrinho)

        initComponents()

        val usuario = usuarioRepository.buscar()?.first()
        usuario?.let { user ->
            tvTitulo.text = "Carrinho do(a) ${user.nome}"
            tvTitulo.esconder()
//            vendasRepository.buscar()
        }

    }

    private fun initComponents() {
        tvTitulo = findViewById(R.id.tvTitulo)
        rvProdutos = findViewById(R.id.rvProdutos)
    }


}