package com.example.calc_carrinho_compras

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.calc_carrinho_compras.domain.gerarRelatorioDescontos
import com.example.calc_carrinho_compras.ui.theme.Calc_carrinho_comprasTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        val carrinho = listOf(
            ItemCarrinho(
                produto = catalogoProdutos[0],
                quantidade = 2
            ),
            ItemCarrinho(
                produto = catalogoProdutos[1],
                quantidade = 1
            ),
            ItemCarrinho(
                produto = catalogoProdutos[2],
                quantidade = 1
            ),
            ItemCarrinho(
                produto = catalogoProdutos[3],
                quantidade = 1
            ),
            ItemCarrinho(
                produto = catalogoProdutos[4],
                quantidade = 1
            ),
            ItemCarrinho(
                produto = catalogoProdutos[5],
                quantidade = 2
            )
        )

        gerarRelatorioDescontos(carrinho)

        setContent {
            Calc_carrinho_comprasTheme {
                CarrinhoScreen(
                    carrinho = carrinho
                )
            }
        }
    }
}