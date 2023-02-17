package com.mazanov.rick_and_morty.presentation.ui.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.mazanov.rick_and_morty.presentation.ui.screens.main_screen.MainScreen
import com.mazanov.rick_and_morty.presentation.theme.Rick_and_mortyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Rick_and_mortyTheme {
                MainScreen()
            }
        }
    }
}

