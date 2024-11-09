package com.example.lab13.ui

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Lab13Exercise5Final() {
    // Estados para las diferentes animaciones
    var isDarkMode by remember { mutableStateOf(false) }
    var isBoxExpanded by remember { mutableStateOf(false) }
    var isButtonVisible by remember { mutableStateOf(true) }

    // Animación de color para el modo oscuro/claro
    val backgroundColor by animateColorAsState(
        targetValue = if (isDarkMode) Color.DarkGray else Color.White,
        animationSpec = tween(durationMillis = 500)
    )

    // Animación de tamaño para el cuadro
    val boxSize by animateDpAsState(
        targetValue = if (isBoxExpanded) 200.dp else 100.dp,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        )
    )

    // Animación de color para el cuadro
    val boxColor by animateColorAsState(
        targetValue = if (isBoxExpanded) Color.Blue else Color.Red,
        animationSpec = tween(durationMillis = 500)
    )

    // Animación de posición para el botón
    val buttonOffset by animateDpAsState(
        targetValue = if (isButtonVisible) 0.dp else 200.dp,
        animationSpec = tween(durationMillis = 500)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Botón para cambiar modo oscuro/claro
        Button(
            onClick = { isDarkMode = !isDarkMode },
            colors = ButtonDefaults.buttonColors(
                containerColor = if (isDarkMode) Color.LightGray else Color.DarkGray
            )
        ) {
            Text(if (isDarkMode) "Modo Claro" else "Modo Oscuro")
        }

        // Cuadro animado que cambia de tamaño y color
        Box(
            modifier = Modifier
                .size(boxSize)
                .background(boxColor)
                .clickable { isBoxExpanded = !isBoxExpanded },
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = if (isBoxExpanded) "Contraer" else "Expandir",
                color = Color.White
            )
        }

        // Botón con AnimatedVisibility
        AnimatedVisibility(
            visible = isButtonVisible,
            enter = fadeIn() + slideInVertically(),
            exit = fadeOut() + slideOutHorizontally()
        ) {
            Button(
                onClick = { isButtonVisible = false },
                modifier = Modifier.offset(x = buttonOffset)
            ) {
                Text("¡Desaparecer!")
            }
        }

        // Botón para restaurar el botón que desaparece
        if (!isButtonVisible) {
            Button(onClick = { isButtonVisible = true }) {
                Text("Restaurar botón")
            }
        }

        // Contenido que cambia según el modo
        AnimatedContent(
            targetState = isDarkMode,
            transitionSpec = {
                fadeIn(animationSpec = tween(600)) togetherWith
                        fadeOut(animationSpec = tween(200))
            }
        ) { isDark ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                colors = CardDefaults.cardColors(
                    containerColor = if (isDark)
                        MaterialTheme.colorScheme.surfaceVariant
                    else
                        MaterialTheme.colorScheme.surface
                )
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = if (isDark)
                            "¡Modo Oscuro Activado!"
                        else
                            "¡Modo Claro Activado!",
                        style = MaterialTheme.typography.headlineSmall
                    )
                }
            }
        }
    }
}