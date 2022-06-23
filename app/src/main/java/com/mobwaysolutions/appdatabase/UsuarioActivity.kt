package com.mobwaysolutions.appdatabase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.textfield.TextInputLayout
import com.mobwaysolutions.appdatabase.entity.ProdutoEntidade
import com.mobwaysolutions.appdatabase.entity.UsuarioEntidade
import com.mobwaysolutions.appdatabase.repository.UsuarioRepository

class UsuarioActivity : AppCompatActivity() {

    lateinit var tilEmail: TextInputLayout
    lateinit var tilNome: TextInputLayout
    lateinit var buttonSave: Button

    private val usuarioRepository = UsuarioRepository(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_usuario)
        initComponents()
        checkUsers()

        buttonSave.setOnClickListener { saveToLocalDb() }
    }

    private fun initComponents() {
        tilEmail = findViewById(R.id.tilEmail)
        tilNome = findViewById(R.id.tilNome)
        buttonSave = findViewById(R.id.bSave)
    }

    private fun checkUsers() {
        val listaDeUsers = usuarioRepository.buscar()
        if (listaDeUsers?.isNotEmpty() == true) {
            proximaTela(CadastroServicoActivity::class.java)
        }
    }

    private fun proximaTela(clazz: Class<*>) {
        val listaDeUsers = usuarioRepository.buscar()
        if (listaDeUsers?.isNotEmpty() == true) {
            Intent(this, clazz).let {
                it.putExtra("usuario_id", listaDeUsers.first().id)
                startActivity(it)
            }
        }
    }

    private fun saveToLocalDb() {
        val nomeDaTela = tilNome.editText?.text.toString()
        val emailDaTela = tilEmail.editText?.text.toString()
        if (nomeDaTela.isNotEmpty() && emailDaTela.isNotEmpty()) {
            tilNome.error = null
            tilEmail.error = null

            val usuarioEntidade =
                UsuarioEntidade(
                    nome = nomeDaTela,
                    email = emailDaTela
                )

            usuarioRepository.inserir(usuarioEntidade)

            // outra tela
            proximaTela(CadastroServicoActivity::class.java)
        } else {
            tilNome.error = "Nome não pode estar em branco"
            tilEmail.error = "Nome não pode estar em branco"
        }
    }
}