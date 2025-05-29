package com.example.characterblank.data.model

data class WeaponsAndArmor( // bloc "Д"
    var shield: Boolean = false,
    var lightArmor: Boolean = false,
    var mediumArmor: Boolean = false,
    var heavyArmor: Boolean = false,
    var simpleWeapon: Boolean = false,
    var specialWeapon: Boolean = false,
    var notes: String = ""
)