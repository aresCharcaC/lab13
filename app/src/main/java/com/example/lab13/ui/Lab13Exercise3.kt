package com.example.lab13.ui

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
fun Lab13Exercise3() {
    var isExpanded by remember { mutableStateOf(false) }

    // Animación del tamaño
    val size by animateDpAsState(
        targetValue = if (isExpanded) 200.dp else 100.dp,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        )
    )

    // Animación de la posición horizontal
    val offsetX by animateDpAsState(
        targetValue = if (isExpanded) 100.dp else 0.dp,
        animationSpec = tween(durationMillis = 500)
    )

    // Animación de la posición vertical
    val offsetY by animateDpAsState(
        targetValue = if (isExpanded) 50.dp else 0.dp,
        animationSpec = tween(durationMillis = 500)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { isExpanded = !isExpanded },
            modifier = Modifier.padding(bottom = 32.dp)
        ) {
            Text(if (isExpanded) "Contraer" else "Expandir")
        }

        // Cuadro animado
        Box(
            modifier = Modifier
                .offset(x = offsetX, y = offsetY) // Primero el offset
                .size(size) // Luego el tamaño
                .background(Color.Blue)
        )

        // Ejemplo con orden diferente de modificadores
        Box(
            modifier = Modifier
                .padding(top = 32.dp)
                .size(size) // Primero el tamaño
                .offset(x = offsetX, y = offsetY) // Luego el offset
                .background(Color.Red)
        )
    }
}