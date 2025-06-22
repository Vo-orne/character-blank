package com.example.characterblank.ui.screens.character

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.characterblank.data.model.Character
import com.example.characterblank.ui.screens.home.AsyncPreviewImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharacterFormScreen(
    character: Character,
    onBackClick: () -> Unit,
    onSettingsClick: () -> Unit,
    onUpdate: (Character) -> Unit,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(character.name) },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = {
                    IconButton(onClick = onSettingsClick) {
                        Icon(Icons.Default.Settings, contentDescription = "Settings")
                    }
                }
            )
        }
    ) { padding ->
        LazyColumn(modifier = Modifier.padding(padding)) {
            item {
                CharacterFormSection(
                    sectionLetter = "M",
                    title = "Portrait",
                    content = {
                        val portraitUri = character.portraitUri
                        portraitUri?.let {
                            when {
                                portraitUri.startsWith("android.resource://") -> {
                                    // Extract resource name from URI
                                    val resName = portraitUri.substringAfterLast("/")
                                    AsyncPreviewImage(resName)
                                }

                                portraitUri.isNotEmpty() -> {
                                    AsyncImage(
                                        model = portraitUri,
                                        contentDescription = "Portrait",
                                        modifier = Modifier.size(64.dp)
                                    )
                                }
                            }
                        } ?: Text("No portrait available")
                    },
                    onEdit = {}
                )
            }
            item {
                CharacterFormSection(
                    sectionLetter = "A",
                    title = "Main Info",
                    content = {
                        Text("Name: ${character.name}")
                        Text("Class: ${character.characterClass}")
                        Text("Race: ${character.race}")
                        Text("Level: ${character.level}")
                        Text("Experience: ${character.experience}")
                    },
                    onEdit = {}
                )
            }
            item {
                CharacterFormSection("B", "Characteristics", {
                    Text("Strength: ${character.characteristics.strength} (${character.characteristics.strengthMod})")
                    Text("Dexterity: ${character.characteristics.dexterity} (${character.characteristics.dexterityMod})")
                    Text("Constitution: ${character.characteristics.constitution} (${character.characteristics.constitutionMod})")
                    Text("Intelligence: ${character.characteristics.intelligence} (${character.characteristics.intelligenceMod})")
                    Text("Wisdom: ${character.characteristics.wisdom} (${character.characteristics.wisdomMod})")
                    Text("Charisma: ${character.characteristics.charisma} (${character.characteristics.charismaMod})")
                }, onEdit = {})
            }
            item {
                CharacterFormSection("C", "Racial Traits", {
                    Text("Speed: ${character.racialCharacteristics.speed}")
                    Text("Traits: ${character.racialCharacteristics.rCTraits}")
                }, onEdit = {})
            }
            item {
                CharacterFormSection("D", "Skills", {
                    Text("Acrobatics: ${character.skills.acrobatics.total}")
                    Text("Bluff: ${character.skills.bluff.total}")
                    Text("Riding: ${character.skills.riding.total}")
                    Text("Attention: ${character.skills.attention.total}")
                    Text("Diplomacy: ${character.skills.diplomacy.total}")
                }, onEdit = {})
            }
            item {
                CharacterFormSection("E", "Weapons and Armor", {
                    Text("Light Armor: ${character.weaponsAndArmor.lightArmor}")
                    Text("Medium Armor: ${character.weaponsAndArmor.mediumArmor}")
                    Text("Heavy Armor: ${character.weaponsAndArmor.heavyArmor}")
                    Text("Simple Weapon: ${character.weaponsAndArmor.simpleWeapon}")
                    Text("Special Weapon: ${character.weaponsAndArmor.specialWeapon}")
                    Text("Notes: ${character.weaponsAndArmor.notes}")
                }, onEdit = {})
            }
            item {
                CharacterFormSection("F", "Class Traits", {
                    Text("Health: ${character.classCharacteristics.health}")
                    Text("Fortitude: ${character.classCharacteristics.fortitude}")
                    Text("Reflex: ${character.classCharacteristics.reaction}")
                    Text("Will: ${character.classCharacteristics.will}")
                    Text("Attack Bonus: ${character.classCharacteristics.attackMod}")
                    Text("Skill Points: ${character.classCharacteristics.skillPoints}")
                    Text("Traits: ${character.classCharacteristics.cCTraits}")
                }, onEdit = {})
            }
            item {
                CharacterFormSection("G", "Attacks", {
                    Text("Initiative: ${character.attacks.initiativeSum}")
                    Text("Melee Attack: ${character.attacks.meleeAttack}")
                    Text("Ranged Attack: ${character.attacks.rangedAttackSum}")
                    Text("Weapon 1: ${character.attacks.weapon1.damage} (${character.attacks.weapon1.type})")
                    Text("Weapon 2: ${character.attacks.weapon2.damage} (${character.attacks.weapon2.type})")
                }, onEdit = {})
            }
            item {
                CharacterFormSection("H", "Armor", {
                    Text("Armor: ${character.armor.aArmor}")
                    Text("Shield: ${character.armor.shield}")
                    Text("Dexterity: ${character.armor.dex}")
                    Text("Magic: ${character.armor.magic}")
                    Text("Total AC: ${character.armor.totalAC}")
                }, onEdit = {})
            }
            item {
                CharacterFormSection("I", "Character Traits", {
                    Text(character.characterTraits)
                }, onEdit = {})
            }
            item {
                CharacterFormSection("J", "Equipment", {
                    Text("Gold: ${character.equipment.goldCoins}")
                    Text("Silver: ${character.equipment.silverCoins}")
                    Text("Copper: ${character.equipment.copperCoins}")
                    Text("Content: ${character.equipment.content}")
                }, onEdit = {})
            }
            item {
                CharacterFormSection("K", "Spells", {
                    Text("Tricks: ${character.spells.tricks}")
                    Text("Level 1: ${character.spells.level1}")
                    Text("Level 2: ${character.spells.level2}")
                    Text("Level 3: ${character.spells.level3}")
                    Text("Spells: ${character.spells.spells}")
                }, onEdit = {})
            }
            item {
                CharacterFormSection("L", "Backstory", {
                    Text(character.backstory)
                }, onEdit = {})
            }
            item {
                CharacterFormSection("N", "Defeated Monsters", {
                    Text(character.defeatedMonsters)
                }, onEdit = {})
            }
            item {
                CharacterFormSection("O", "Damage Record", {
                    Text(character.damageRecord)
                }, onEdit = {})
            }
            item {
                CharacterFormSection("P", "Character Notes", {
                    Text(character.characterNotes)
                }, onEdit = {})
            }
        }
    }
}

@Composable
fun CharacterFormSection(
    sectionLetter: String,
    title: String,
    content: @Composable ColumnScope.() -> Unit,
    onEdit: () -> Unit,
) {
    var isEditing by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "$sectionLetter: $title", style = MaterialTheme.typography.titleMedium)
                IconButton(onClick = {
                    if (isEditing) {
                        onEdit()
                    }
                    isEditing = !isEditing
                }) {
                    Icon(
                        imageVector = if (isEditing) Icons.Default.Check else Icons.Default.Edit,
                        contentDescription = if (isEditing) "Save" else "Edit"
                    )
                }
            }
            content()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CharacterFormScreenPreview() {
    CharacterFormScreen(
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
        onBackClick = {},
        onSettingsClick = {},
        onUpdate = {}
    )
}