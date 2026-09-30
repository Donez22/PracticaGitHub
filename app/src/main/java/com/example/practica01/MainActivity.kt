package com.example.practica01

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.practica01.ui.theme.Practica01Theme

class MainActivity : ComponentActivity() {

    private var mostrarSegundaPantalla by mutableStateOf(false)
    private var mensaje by mutableStateOf("")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {

            Practica01Theme {

                if (mostrarSegundaPantalla) {

                    SecondScreen(
                        mensaje = mensaje,
                        onVolver = {
                            mostrarSegundaPantalla = false
                        }
                    )

                } else {

                    FirstScreen(
                        onNavigateToSecondScreen = { texto ->
                            mensaje = texto
                            mostrarSegundaPantalla = true
                        }
                    )
                }
            }
        }
    }
}