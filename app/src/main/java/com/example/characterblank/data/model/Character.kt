package com.example.characterblank.data.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "characters")
data class Character(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    // A: Main info
    val name: String,
    var level: Int,
    val race: String,
    val characterClass: String,
    var portraitUri: String? = null,                                                      // М
    var experience: Int,
    var worldview: String,
    val gender: String,

    @Embedded val characteristics: Characteristics = Characteristics(),                   // Б
    @Embedded val racialCharacteristics: RacialCharacteristics = RacialCharacteristics(), // В
    @Embedded val skills: Skills = Skills(),                                              // Г
    @Embedded val weaponsAndArmor: WeaponsAndArmor = WeaponsAndArmor(),                   // Д
    @Embedded val classCharacteristics: ClassCharacteristics = ClassCharacteristics(),    // Е
    @Embedded val attacks: Attacks = Attacks(),                                           // Ж
    @Embedded val armor: Armor = Armor(),                                                 // З
    var traits: String = "",                                                              // И
    @Embedded val equipment: Equipment = Equipment(),                                     // К
    @Embedded val spells: Spells = Spells(),                                              // Л
    var backstory: String = "",                                                           // H
    var defeatedMonsters: String = "",                                                    // O
    var damageRecord: String = "",                                                        // П
    var notes: String = "",                                                               // P
)