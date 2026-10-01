package com.example.calc_carrinho_compras.domain

import android.util.Log
import com.example.calc_carrinho_compras.ItemCarrinho

fun gerarRelatorioDescontos(carrinho: List<ItemCarrinho>) {

    val produtosComDesconto = carrinho

        .filter { it.produto.descontoPercentual > 0 }

        .map { item ->
            val valorFinal = calcularTotalItem(item)

            item.produto.nome to valorFinal
        }

        .sortedByDescending { it.second }

    Log.d("RELATORIO_CARRINHO", "================================")
    Log.d("RELATORIO_CARRINHO", "       RELATÓRIO DE DESCONTOS")
    Log.d("RELATORIO_CARRINHO", "================================")

    produtosComDesconto.forEach { (nome, valorFinal) ->

        Log.d(
            "RELATORIO_CARRINHO",
            "$nome - R$ ${"%.2f".format(valorFinal)}"
        )
    }

    Log.d("RELATORIO_CARRINHO", "================================")
}