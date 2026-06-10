package com.projeto.unibook1.ui.admin

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun AdminRegisterScreen(onBackToLogin: () -> Unit) {
    val AdminDarkBlue = Color(0xFF2F2C79)
    val AdminBluePrimary = Color(0xFF2196F3)

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Cadastro de Admin", style = MaterialTheme.typography.headlineMedium, color = AdminDarkBlue)

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(value = "", onValueChange = {}, label = { Text("Nome Completo") })
        OutlinedTextField(value = "", onValueChange = {}, label = { Text("Matrícula") })
        OutlinedTextField(value = "", onValueChange = {}, label = { Text("Senha") })

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { /* Lógica de cadastro */ },
            colors = ButtonDefaults.buttonColors(containerColor = AdminDarkBlue)
        ) {
            Text("Finalizar Cadastro")
        }

        Spacer(modifier = Modifier.height(8.dp))

        TextButton(onClick = onBackToLogin) {
            Text("Já tem conta? Faça Login", color = AdminBluePrimary)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AdminRegisterScreenPreview() {
    // Passamos um bloco vazio {} para o parâmetro de navegação
    AdminRegisterScreen(onBackToLogin = {})
}
