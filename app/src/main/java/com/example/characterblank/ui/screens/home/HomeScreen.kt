package com.example.characterblank.ui.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.characterblank.data.model.Character
import coil.compose.AsyncImage
import androidx.compose.ui.res.painterResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    characters: List<Character>,
    onCharacterClick: (Character) -> Unit,
    onAddCharacterClick: () -> Unit,
    onSettingsClick: () -> Unit,
    onLongClick: (Character) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Character Blank") },
                actions = {
                    IconButton(onClick = onSettingsClick) {
                        Icon(Icons.Default.Settings, contentDescription = "Settings")
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = onAddCharacterClick) {
                Icon(Icons.Default.Add, contentDescription = "Add Character")
            }
        }
    ) { padding ->
        LazyColumn(modifier = Modifier.padding(padding)) {
            items(characters) { character ->
                CharacterCard(
                    character = character,
                    onClick = { onCharacterClick(character) },
                    onLongClick = { onLongClick(character) }
                )
            }
        }
    }
}

@Composable
fun CharacterCard(
    character: Character,
    onClick: () -> Unit,
    onLongClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .combinedClickable(
                onClick = onClick,
                onLongClick = onLongClick
            ),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(modifier = Modifier.padding(16.dp)) {
            val portraitUri = character.portraitUri
            when {
                portraitUri?.startsWith("android.resource://") == true -> {
                    // Extract resource name from URI
                    val resName = portraitUri.substringAfterLast("/")
                    AsyncPreviewImage(resName)
                }
                !portraitUri.isNullOrEmpty() -> {
                    AsyncImage(
                        model = portraitUri,
                        contentDescription = "Portrait",
                        modifier = Modifier.size(64.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(character.name, style = MaterialTheme.typography.titleMedium)
                Text("Level: ${character.level}  Class: ${character.characterClass}")
                Text("Race: ${character.race}")
            }
        }
    }
}

@SuppressLint("DiscouragedApi")
@Composable
fun AsyncPreviewImage(resourceName: String) {
    // Get the Android context object from the Compose environment
    val context = androidx.compose.ui.platform.LocalContext.current
    // Remember (cache) the result of finding the resource ID by name (for example, "elf_male")
    val resId = remember(resourceName) {
        // Using the Android function, we get the ID of the drawable resource by its name
        context.resources.getIdentifier(resourceName, "drawable", context.packageName)
    }

    // If a valid resource is found (ID not 0), display the image
    if (resId != 0) {
        // Use the standard Image from painterResource to display the image by ID
        androidx.compose.foundation.Image(
            painter = painterResource(id = resId),
            contentDescription = "Portrait",
            modifier = Modifier.size(64.dp)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(
        characters = listOf(
            Character(
                name = "Aragorn",
                level = 5,
                race = "Human",
                characterClass = "Ranger",
                experience = 1400,
                worldview = "Neutral Good",
                gender = "Male",
                portraitUri = "android.resource://com.example.characterblank/drawable/human_male"
            )
        ),
        onCharacterClick = {},
        onAddCharacterClick = {},
        onSettingsClick = {},
        onLongClick = {}
    )
}

@Preview(showBackground = true)
@Composable
fun CharacterCardPreview() {
    CharacterCard(
        character = Character(
            name = "Legolas",
            level = 4,
            race = "Elf",
            characterClass = "Bowman",
            experience = 1200,
            worldview = "Chaotic Good",
            gender = "Male",
            portraitUri = "android.resource://com.example.characterblank/drawable/elf_male"
        ),
        onClick = {},
        onLongClick = {}
    )
}