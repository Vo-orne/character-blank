package com.example.characterblank.data.model

import androidx.room.Embedded

data class Attacks( // bloc "Ж"
    var improvingInitiative: Int = 0,
    var dexInitiative: Int = 0,
    val initiativeSum: Int = improvingInitiative + dexInitiative,
    var meleeAttackMod: Int = 0,
    var strMeleeAttack: Int = 0,
    val meleeAttack: Int = meleeAttackMod + strMeleeAttack,
    var rangedAttackMod: Int = 0,
    var dexRangedAttack: Int = 0,
    val rangedAttackSum: Int = rangedAttackMod + dexRangedAttack,
    @Embedded(prefix = "weapon1_")
    var weapon1: Weapon = Weapon(),
    @Embedded(prefix = "weapon2_")
    var weapon2: Weapon = Weapon()
)

data class Weapon(
    var attackMod: String = "",
    var damage: String = "",
    var criticalHit: String = "",
    var type: String = "",
    var range: String = "",
    var projectiles: String = "",
)
