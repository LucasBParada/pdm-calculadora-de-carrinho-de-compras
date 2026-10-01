package com.example.calc_carrinho_compras.domain

import com.example.calc_carrinho_compras.Produto
import com.example.calc_carrinho_compras.ItemCarrinho


fun calcularPrecoComDesconto(produto: Produto): Double {
    val desconto = produto.preco * (produto.descontoPercentual / 100)

    return produto.preco - desconto
}

fun calcularTotalItem(item: ItemCarrinho): Double {
    return calcularPrecoComDesconto(item.produto) * item.quantidade
}