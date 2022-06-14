package com.mobwaysolutions.appdatabase.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mobwaysolutions.appdatabase.R
import com.mobwaysolutions.appdatabase.database.ProdutoEntidade

class ProdutoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val tvNomeProduto: TextView = itemView.findViewById(R.id.tvNomeProduto)

    fun bind(produto: ProdutoEntidade) {
        tvNomeProduto.text = produto.nome
    }

}