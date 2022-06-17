package com.mobwaysolutions.appdatabase.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mobwaysolutions.appdatabase.R
import com.mobwaysolutions.appdatabase.entity.ProdutoEntidade

class ProdutoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val tvNomeProduto: TextView = itemView.findViewById(R.id.tvNomeProduto)
    private val tvPrecoProduto: TextView = itemView.findViewById(R.id.tvPrecoProduto)
    val ivAddCart: ImageView = itemView.findViewById(R.id.ivAddCart)

    fun bind(produto: ProdutoEntidade) {
        tvNomeProduto.text = produto.nome
        tvPrecoProduto.text = produto.preco.toString()
    }

}