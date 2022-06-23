package com.mobwaysolutions.appdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputLayout
import com.mobwaysolutions.appdatabase.entity.EnderecoDTO
import com.mobwaysolutions.appdatabase.entity.ServicoEntidade
import com.mobwaysolutions.appdatabase.entity.UsuarioEntidade
import com.mobwaysolutions.appdatabase.repository.ServicoRepository
import com.mobwaysolutions.appdatabase.repository.UsuarioRepository

class CadastroServicoActivity : AppCompatActivity() {

    lateinit var tilNome: TextInputLayout
    lateinit var tilRua: TextInputLayout
    lateinit var tilNumero: TextInputLayout
    lateinit var tilCidade: TextInputLayout
    lateinit var buttonSave: MaterialButton

    val servicoRepository = ServicoRepository(this)
    val usuarioRepository = UsuarioRepository(this)
    var usuarioEntidade : UsuarioEntidade? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_servico)
        initComponents()

        val userId = intent.getIntExtra("usuario_id", 0)
        usuarioEntidade = usuarioRepository.buscarPorId(userId)

        buttonSave.setOnClickListener {

            usuarioEntidade?.let { userEntity ->
                ServicoEntidade(
                    id = 0,
                    nome = tilNome.editText?.text.toString(),
                    endereco = EnderecoDTO(
                        rua = tilRua.editText?.text.toString(),
                        numero = tilNumero.editText?.text.toString(),
                        cidade = tilCidade.editText?.text.toString()
                    ),
                    usuario = userEntity
                ).also {
                    servicoRepository.inserir(it)
                }
            }
        }
    }

    private fun initComponents() {
        tilNome = findViewById(R.id.tilNome)
        tilRua = findViewById(R.id.tilRua)
        tilNumero = findViewById(R.id.tilNumero)
        tilCidade = findViewById(R.id.tilCidade)
        buttonSave = findViewById(R.id.bSave)
    }
}