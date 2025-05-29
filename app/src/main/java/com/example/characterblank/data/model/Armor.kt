package com.example.characterblank.data.model

data class Armor( // bloc "З"
    var armor: Int = 0,
    var shield: Int = 0,
    var dex: Int = 0,
    var magic: Int = 0,
    var totalAC: Int = 10,
    val sum: Int = armor + shield + dex + magic + totalAC
)
