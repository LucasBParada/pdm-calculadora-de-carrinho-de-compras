package com.example.calc_carrinho_compras.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColorScheme = lightColorScheme(
    primary = VerdePrincipal,
    onPrimary = Branco,

    secondary = VerdeClaro,
    onSecondary = Branco,

    tertiary = VerdeEscuro,

    background = CinzaFundo,
    onBackground = CinzaTexto,

    surface = CinzaSuperficie,
    onSurface = CinzaTexto,

    surfaceVariant = Color(0xFFE4E9E6),
    onSurfaceVariant = CinzaSecundario
)

private val DarkColorScheme = darkColorScheme(
    primary = VerdeClaro,
    onPrimary = Color.Black,

    secondary = VerdePrincipal,
    onSecondary = Branco,

    tertiary = VerdeClaro,

    background = Color(0xFF121212),
    onBackground = Branco,

    surface = Color(0xFF1E1E1E),
    onSurface = Branco,

    surfaceVariant = Color(0xFF303530),
    onSurfaceVariant = Color(0xFFBFC8C1)
)

@Composable
fun Calc_carrinho_comprasTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) {
        DarkColorScheme
    } else {
        LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}