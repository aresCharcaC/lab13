package com.example.lab13

import Lab13Exercise4
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.lab13.ui.Lab13Exercise3
import com.example.lab13.ui.Lab13Exercise5Final
import com.example.lab13.ui.theme.Lab13Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab13Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //Lab13()
                    //Lab13Exercise2()
                    //Lab13Exercise3()
                    //Lab13Exercise4()
                    Lab13Exercise5Final()


                }
            }
        }
    }
}