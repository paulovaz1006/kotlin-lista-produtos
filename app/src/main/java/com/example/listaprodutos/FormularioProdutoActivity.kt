package com.example.listaprodutos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.listaprodutos.dao.ProdutosDao
import com.example.listaprodutos.model.Produto
import java.math.BigDecimal

class FormularioProdutoActivity : AppCompatActivity(R.layout.activity_formulario_produto) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val botaoSalvar = findViewById<Button>(R.id.formulario_produto_botao_salvar)
        configuraBotaoSalvar(botaoSalvar)

    }

    private fun configuraBotaoSalvar(botaoSalvar: Button) {
        val dao = ProdutosDao()

        botaoSalvar.setOnClickListener {
            val produtoNovo = criaProduto()
            dao.adiciona(produtoNovo)
            finish()
        }
    }

    private fun criaProduto(): Produto {
        val campoNome = findViewById<EditText>(R.id.formulario_produto_nome)
        val campoValor = findViewById<EditText>(R.id.formulario_produto_valor)
        val campoDescricao = findViewById<EditText>(R.id.formulario_produto_descricao)
        val nome = campoNome.text.toString()
        val descricao = campoDescricao.text.toString()
        val valorEmTexto = campoValor.text.toString()
        val valor = if (valorEmTexto.isBlank()) {
            BigDecimal.ZERO
        } else {
            BigDecimal(valorEmTexto)
        }

        return Produto(
            nome = nome,
            descricao = descricao,
            valor = valor
        )
    }
}