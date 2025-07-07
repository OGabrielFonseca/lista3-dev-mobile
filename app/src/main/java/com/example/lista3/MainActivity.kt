package com.example.lista3

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val editTextNomeCompleto: EditText = findViewById(R.id.editTextNomeCompleto)
        val editTextEmail: EditText = findViewById(R.id.editTextEmail)
        val spinnerGenero: Spinner = findViewById(R.id.spinnerGenero)
        val radioGrupoIdade: RadioGroup = findViewById(R.id.radioGrupoIdade)
        val checkboxNotificacoes: CheckBox = findViewById(R.id.checkboxNotificacoes)
        val botaoCadastrar: Button = findViewById(R.id.botaoCadastrar)

        val generosLiterarios = listOf(
            "Ficção Científica", "Fantasia", "Romance",
            "Suspense", "Biografia", "Não-Ficção"
        )

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            generosLiterarios
        )

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerGenero.adapter = adapter

        botaoCadastrar.setOnClickListener {
            val nomeCompleto = editTextNomeCompleto.text.toString()
            val email = editTextEmail.text.toString()
            val generoSelecionado = spinnerGenero.selectedItem.toString()

            val idRadioIdadeSelecionado = radioGrupoIdade.checkedRadioButtonId
            val faixaEtaria = if (idRadioIdadeSelecionado != -1) {
                findViewById<RadioButton>(idRadioIdadeSelecionado).text.toString()
            } else {
                "Não selecionado"
            }

            val desejaNotificacoes = checkboxNotificacoes.isChecked

            if (nomeCompleto.isBlank() || email.isBlank() || idRadioIdadeSelecionado == -1) {
                Toast.makeText(this, "Por favor, preencha todos os campos obrigatórios.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val intencao = Intent(this, SummaryActivity::class.java).apply {
                putExtra("NOME_COMPLETO", nomeCompleto)
                putExtra("EMAIL", email)
                putExtra("GENERO", generoSelecionado)
                putExtra("FAIXA_ETARIA", faixaEtaria)
                putExtra("NOTIFICACOES", desejaNotificacoes)
            }

            startActivity(intencao)
        }
    }
}