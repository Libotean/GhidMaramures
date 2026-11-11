package com.example.ghidmaramures

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.ghidmaramures.navigation.AppNavHost
import com.example.ghidmaramures.ui.theme.GhidMaramuresTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GhidMaramuresTheme {
                AppNavHost()
            }
        }
    }
}
