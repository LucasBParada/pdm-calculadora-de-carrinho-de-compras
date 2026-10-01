# 🛒 Calculadora de Carrinho de Compras

Aplicativo Android desenvolvido em **Kotlin** com **Jetpack Compose** para simular um carrinho de compras, com produtos, quantidades, descontos e cálculo do valor total.

![Kotlin](https://img.shields.io/badge/Kotlin-2.0.21-7F52FF?logo=kotlin&logoColor=white)
![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-4285F4?logo=jetpackcompose&logoColor=white)
![Material Design 3](https://img.shields.io/badge/Material%20Design-3-757575?logo=materialdesign&logoColor=white)
![Min SDK](https://img.shields.io/badge/Min%20SDK-24-3DDC84?logo=android&logoColor=white)
![Target SDK](https://img.shields.io/badge/Target%20SDK-36-3DDC84?logo=android&logoColor=white)

---

## 📑 Sumário

- [Funcionalidades](#-funcionalidades)
- [Tecnologias](#️-tecnologias)
- [Versões](#-versões)
- [Estrutura do projeto](#-estrutura-do-projeto)
- [Principais componentes](#-principais-componentes)
- [Operações funcionais utilizadas](#-operações-funcionais-utilizadas)
- [Cálculo](#-cálculo)
- [Como executar](#️-como-executar)
- [Exemplo do Logcat](#-exemplo-do-logcat)
- [Autor](#-autor)

---

## 📱 Funcionalidades

- Catálogo com produtos pré-definidos
- Controle da quantidade de produtos
- Aplicação de descontos
- Cálculo do valor final dos produtos
- Cálculo do desconto total
- Cálculo do valor total do carrinho
- Exibição dos produtos em cards
- Relatório de produtos com desconto no Logcat
- Interface desenvolvida com Jetpack Compose
- Tratamento de produtos sem descrição

## 🛠️ Tecnologias

- Kotlin
- Android
- Jetpack Compose
- Material Design 3
- Gradle
- Android Studio

## 📦 Versões

| Tecnologia            | Versão     |
|-----------------------|------------|
| Kotlin                | 2.0.21     |
| Android Gradle Plugin | 8.13.2     |
| Compile SDK           | 36         |
| Target SDK            | 36         |
| Min SDK               | 24         |
| Java                  | 11         |
| Compose BOM           | 2024.09.00 |

**Application ID:**

```
com.example.calc_carrinho_compras
```

## 📂 Estrutura do projeto

```
app/
└── src/
    └── main/
        ├── java/com/example/calc_carrinho_compras/
        │   ├── MainActivity.kt
        │   ├── Pagavel.kt
        │   ├── Produto.kt
        │   ├── ItemCarrinho.kt
        │   ├── Catalogo.kt
        │   ├── ItemProduto.kt
        │   ├── CarrinhoScreen.kt
        │   │
        │   ├── domain/
        │   │   ├── CalculoCarrinho.kt
        │   │   └── RelatorioCarrinho.kt
        │   │
        │   └── ui/theme/
        │       ├── Color.kt
        │       ├── Theme.kt
        │       └── Type.kt
        │
        └── AndroidManifest.xml
```

## 🧩 Principais componentes

### `Produto`

Representa os produtos do catálogo. Possui:

- Nome
- Preço
- Descrição opcional
- Percentual de desconto

### `ItemCarrinho`

Relaciona um produto com sua quantidade.

### `Pagavel`

Interface responsável por definir o método de cálculo do total.

### `CalculoCarrinho`

Contém as funções responsáveis pelo cálculo de descontos e valores finais.

### `RelatorioCarrinho`

Filtra os produtos com desconto, ordena os valores e exibe o resultado no Logcat.

### `ItemProduto`

Componente reutilizável responsável pela exibição de cada produto.

### `CarrinhoScreen`

Tela principal do carrinho, contendo:

- Título
- Lista de produtos
- Quantidade total
- Desconto total
- Valor total

## 🔢 Operações funcionais utilizadas

O projeto utiliza operações funcionais do Kotlin para filtrar, transformar, ordenar e calcular os valores do carrinho:

| Operação             | Uso                |
|----------------------|--------------------|
| `filter`             | Filtrar produtos   |
| `map`                | Transformar dados  |
| `sortedByDescending` | Ordenar valores    |
| `reduceOrNull`       | Reduzir coleções   |
| `sumOf`              | Somar valores      |

## 💰 Cálculo

```
Desconto      = Preço × (Percentual / 100)
Preço final   = Preço − Desconto
Total do item = Preço final × Quantidade
```

O aplicativo também calcula o desconto acumulado de todos os produtos e o valor final do carrinho.

## ▶️ Como executar

### 1. Clonar o projeto

```bash
git clone https://github.com/LucasBParada/pdm-calculadora-de-carrinho-de-compras.git
```

### 2. Abrir no Android Studio

Abra a pasta do projeto no Android Studio e aguarde a sincronização do Gradle.

### 3. Executar

Conecte um dispositivo Android ou inicie um emulador e pressione **Run ▶**.

### 🔨 Build pelo terminal

No Windows:

```bash
gradlew.bat assembleDebug
```

Para executar os testes:

```bash
gradlew.bat test
```

## 📋 Exemplo do Logcat

Ao iniciar o aplicativo, os produtos que possuem desconto são exibidos no Logcat, ordenados pelo valor final:

```
RELATÓRIO DE DESCONTOS
========================================
Notebook para Desenvolvimento... - R$ 3324,91
Teclado Mecânico RGB - R$ 212,42
Mouse Sem Fio - R$ 161,82
----------------------------------------
TOTAL: R$ 3699,15
========================================
```

## 👨‍💻 Autor

**Lucas Parada**

Projeto desenvolvido para fins acadêmicos.
