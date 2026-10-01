package com.example.calc_carrinho_compras

data class ItemCarrinho(
    val produto: Produto,
    val quantidade: Int
): Pagavel {
    override fun calcularTotal(): Double {
        return produto.calcularTotal() * quantidade
    }
}