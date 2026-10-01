package com.example.calc_carrinho_compras

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.calc_carrinho_compras.domain.calcularPrecoComDesconto
import com.example.calc_carrinho_compras.domain.calcularTotalItem
import java.util.Locale

@Composable
fun CarrinhoScreen(
    carrinho: List<ItemCarrinho>
) {
    val totalCarrinho = carrinho.sumOf { item ->
        calcularTotalItem(item)
    }

    val quantidadeProdutos = carrinho.sumOf { item ->
        item.quantidade
    }

    val descontoTotal = carrinho.sumOf { item ->
        val precoOriginal = item.produto.preco * item.quantidade
        val precoComDesconto = calcularPrecoComDesconto(item.produto) * item.quantidade

        precoOriginal - precoComDesconto
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .safeDrawingPadding()
        ) {

            // CABEÇALHO
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 16.dp,
                        end = 16.dp,
                        top = 16.dp,
                        bottom = 12.dp
                    )
            ) {
                Text(
                    text = "Meu Carrinho",
                    style = MaterialTheme.typography.headlineMedium,
                    color = MaterialTheme.colorScheme.primary
                )

                Text(
                    text = "Confira os produtos adicionados",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            // LISTA DE PRODUTOS
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp),
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    items(carrinho) { item ->
                        ItemProduto(
                            item = item
                        )
                    }
                }
            }

            // RESUMO INFERIOR
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 16.dp,
                        end = 16.dp,
                        top = 8.dp,
                        bottom = 8.dp
                    )
                    .background(
                        color = MaterialTheme.colorScheme.surfaceVariant,
                        shape = MaterialTheme.shapes.medium
                    )
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                // QUANTIDADE
                Column {
                    Text(
                        text = "Quantidade",
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    Text(
                        text = quantidadeProdutos.toString(),
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.primary
                    )
                }

                // DESCONTO
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Desconto",
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    Text(
                        text = "R$ ${
                            String.format(
                                Locale("pt", "BR"),
                                "%.2f",
                                descontoTotal
                            )
                        }",
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.primary
                    )
                }

                // TOTAL
                Column(
                    horizontalAlignment = Alignment.End
                ) {
                    Text(
                        text = "Valor total",
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    Text(
                        text = "R$ ${
                            String.format(
                                Locale("pt", "BR"),
                                "%.2f",
                                totalCarrinho
                            )
                        }",
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }
    }
}