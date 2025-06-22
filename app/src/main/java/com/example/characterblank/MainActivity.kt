package com.example.characterblank

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.example.characterblank.nav.AppNavGraph
import com.example.characterblank.ui.theme.CharacterBlankTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CharacterBlankTheme {
                val navController = rememberNavController()
                AppNavGraph(navController = navController)
            }
        }
    }
}