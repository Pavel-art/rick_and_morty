package com.mazanov.rick_and_morty.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.mazanov.rick_and_morty.presentation.navigation.AppNavGraph
import com.mazanov.rick_and_morty.presentation.navigation.rememberNavigationState
import com.mazanov.rick_and_morty.presentation.screens.character_screen.CharacterScreen
import com.mazanov.rick_and_morty.presentation.screens.main_screen.MainScreen
import com.mazanov.rick_and_morty.presentation.theme.Rick_and_mortyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Rick_and_mortyTheme {
                val navigationState = rememberNavigationState()
                AppNavGraph(
                    navHostController = navigationState.navHostController,
                    personScreenContent = {person ->
                        CharacterScreen(navigationState = navigationState, content = person)
                    },
                    mainScreenContent = {
                        MainScreen(
                            navigationState = navigationState
                        )
                    }
                )
            }
        }
    }
}

