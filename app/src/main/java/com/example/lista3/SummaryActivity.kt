package com.example.lista3

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SummaryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_summary)

        val textViewResumo: TextView = findViewById(R.id.textViewResumo)

        val nomeCompleto = intent.getStringExtra("NOME_COMPLETO")
        val email = intent.getStringExtra("EMAIL")
        val genero = intent.getStringExtra("GENERO")
        val faixaEtaria = intent.getStringExtra("FAIXA_ETARIA")
        val desejaNotificacoes = intent.getBooleanExtra("NOTIFICACOES", false)

        val textoNotificacoes = if (desejaNotificacoes) "Sim" else "Não"

        val textoResumo = """
            Nome: $nomeCompleto
            E-mail: $email
            Gênero Preferido: $genero
            Faixa Etária: $faixaEtaria
            Receber Notificações: $textoNotificacoes
        """.trimIndent()

        textViewResumo.text = textoResumo
    }
}