package com.example.ghidmaramures.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation

@Composable
fun LoginScreen(onLoginClick: () -> Unit){
    var utilizator by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(modifier = Modifier.safeDrawingPadding().fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        OutlinedTextField(
            value = utilizator,
            onValueChange = {utilizator = it},
            label = {Text("Utilizator")}
        )

        OutlinedTextField(
            value = password,
            onValueChange = {password = it},
            label = {Text("Parola")},
            visualTransformation = PasswordVisualTransformation()
        )

        Button(
            onClick = onLoginClick,
            enabled = utilizator.isNotBlank() && password.isNotBlank()
        ) { Text("Login") }
    }

}