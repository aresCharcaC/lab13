package com.example.lab13.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Lab13() {
    // Estado para controlar la visibilidad
    var isVisible by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Botón para alternar la visibilidad
        Button(onClick = { isVisible = !isVisible }) {
            Text(if (isVisible) "Ocultar" else "Mostrar")
        }

        // Elemento animado
        AnimatedVisibility(
            visible = isVisible,
            enter = fadeIn(),  // Animación de entrada
            exit = fadeOut()   // Animación de salida
        ) {
            // Cuadro colorido que aparecerá/desaparecerá
            Box(
                modifier = Modifier
                    .size(200.dp)
                    .background(Color.Blue)
            )
        }
    }
}