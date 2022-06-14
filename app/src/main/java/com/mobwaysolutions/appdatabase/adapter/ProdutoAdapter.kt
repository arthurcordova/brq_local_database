package com.mobwaysolutions.appdatabase.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mobwaysolutions.appdatabase.R
import com.mobwaysolutions.appdatabase.database.ProdutoEntidade

class ProdutoAdapter(private val listaDeProdutos: List<ProdutoEntidade>) :
    RecyclerView.Adapter<ProdutoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdutoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_produto, parent, false)
        return ProdutoViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProdutoViewHolder, position: Int) {
        val produto = listaDeProdutos[position]
        holder.bind(produto)
    }

    override fun getItemCount(): Int {
        return listaDeProdutos.size
    }
}