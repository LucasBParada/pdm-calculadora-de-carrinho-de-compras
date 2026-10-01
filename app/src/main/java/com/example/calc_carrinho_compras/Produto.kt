package com.example.calc_carrinho_compras

data class Produto(
    val nome: String,
    val preco: Double,
    val descricao: String? = null,
    val descontoPercentual: Double = 0.0
) : Pagavel {

    override fun calcularTotal(): Double {
        return preco
    }
}