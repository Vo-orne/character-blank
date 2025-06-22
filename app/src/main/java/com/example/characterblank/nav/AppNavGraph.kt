package com.example.characterblank.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.characterblank.data.model.Character
import com.example.characterblank.ui.screens.character.CharacterFormScreen
import com.example.characterblank.ui.screens.home.HomeScreen

@Composable
fun AppNavGraph(
    navController: NavHostController,
    startDestination: String = "home"
) {
    NavHost(navController = navController, startDestination = startDestination) {

        composable("home") {
            HomeScreen(
                characters = listOf(), // TODO: replace with ViewModel
                onCharacterClick = { character ->
                    navController.navigate("characterForm/${character.id}")
                },
                onAddCharacterClick = {
                    navController.navigate("characterForm/0") // 0 = new character
                },
                onSettingsClick = {
                    navController.navigate("settings")
                },
                onLongClick = {}
            )
        }

        composable("characterForm/{characterId}") { backStackEntry ->
            val characterId = backStackEntry.arguments?.getString("characterId")?.toIntOrNull()

            // Temporal logic: if 0 — create new, otherwise — edit
            val character = if (characterId == 0 || characterId == null) {
                Character(
                    name = "",
                    level = 1,
                    race = "",
                    characterClass = "",
                    experience = 0,
                    worldview = "",
                    gender = ""
                )
            } else {
                // TODO: load character from ViewModel
                Character(
                    name = "Legolas",
                    level = 4,
                    race = "Elf",
                    characterClass = "Bowman",
                    experience = 1200,
                    worldview = "Chaotic Good",
                    gender = "Male",
                    portraitUri = "android.resource://com.example.characterblank/drawable/elf_male"
                )
            }

            CharacterFormScreen(
                character = character,
                onBackClick = { navController.popBackStack() },
                onSettingsClick = {
                    navController.navigate("settings")
                },
                onUpdate = {}
            )
        }

        composable("settings") {
            // TODO: implement settings screen
        }
    }
}
