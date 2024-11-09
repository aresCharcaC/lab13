package com.example.lab13.ui

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.*
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
fun Lab13Exercise2() {
    var isColorChanged by remember { mutableStateOf(false) }

    // Animación del color usando animateColorAsState
    val backgroundColor by animateColorAsState(
        targetValue = if (isColorChanged) Color.Green else Color.Blue,
        // Usando spring para una animación más dinámica
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        )

        // Alternativa usando tween:
        // animationSpec = tween(durationMillis = 1000)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Button(onClick = { isColorChanged = !isColorChanged }) {
            Text(text = "Cambiar Color")
        }

        // Cuadro con color animado
        Box(
            modifier = Modifier
                .size(200.dp)
                .background(backgroundColor)
        )
    }
}

// Version alternativa usando tween
@Composable
fun Lab13Exercise2WithTween() {
    var isColorChanged by remember { mutableStateOf(false) }

    val backgroundColor by animateColorAsState(
        targetValue = if (isColorChanged) Color.Green else Color.Blue,
        animationSpec = tween(
            durationMillis = 1000,
            easing = LinearEasing
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Button(onClick = { isColorChanged = !isColorChanged }) {
            Text(text = "Cambiar Color")
        }

        Box(
            modifier = Modifier
                .size(200.dp)
                .background(backgroundColor)
        )
    }
}