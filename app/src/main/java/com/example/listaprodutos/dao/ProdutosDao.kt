package com.example.listaprodutos.dao

import com.example.listaprodutos.model.Produto

class ProdutosDao {

    fun adiciona(produto: Produto) {
        produtos.add(produto)
    }

    fun buscaTodos(): List<Produto> {
        return produtos.toList()
    }
    companion object {
        private val produtos = mutableListOf<Produto>()
    }
}