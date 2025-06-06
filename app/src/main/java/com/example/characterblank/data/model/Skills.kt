package com.example.characterblank.data.model

import androidx.room.Embedded

data class Skills( // bloc "Г"
    @Embedded(prefix = "acrobatics_") var acrobatics: SkillEntry = SkillEntry(),
    @Embedded(prefix = "bluff_") var bluff: SkillEntry = SkillEntry(),
    @Embedded(prefix = "riding_") var riding: SkillEntry = SkillEntry(),
    @Embedded(prefix = "attention_") var attention: SkillEntry = SkillEntry(),
    @Embedded(prefix = "diplomacy_") var diplomacy: SkillEntry = SkillEntry(),

    @Embedded(prefix = "knowledgeGeography_") var knowledgeGeography: SkillEntry = SkillEntry(),
    @Embedded(prefix = "knowledgeHistory_") var knowledgeHistory: SkillEntry = SkillEntry(),
    @Embedded(prefix = "knowledgeLocal_") var knowledgeLocal: SkillEntry = SkillEntry(),
    @Embedded(prefix = "knowledgeDungeons_") var knowledgeDungeons: SkillEntry = SkillEntry(),
    @Embedded(prefix = "knowledgeNature_") var knowledgeNature: SkillEntry = SkillEntry(),
    @Embedded(prefix = "knowledgeReligion_") var knowledgeReligion: SkillEntry = SkillEntry(),
    @Embedded(prefix = "knowledgeMagic_") var knowledgeMagic: SkillEntry = SkillEntry(),

    @Embedded(prefix = "witchcraft_") var witchcraft: SkillEntry = SkillEntry(),
    @Embedded(prefix = "climbing_") var climbing: SkillEntry = SkillEntry(),
    @Embedded(prefix = "healing_") var healing: SkillEntry = SkillEntry(),
    @Embedded(prefix = "mechanics_") var mechanics: SkillEntry = SkillEntry(),
    @Embedded(prefix = "swimming_") var swimming: SkillEntry = SkillEntry(),
    @Embedded(prefix = "insight_") var insight: SkillEntry = SkillEntry(),
    @Embedded(prefix = "stealth_") var stealth: SkillEntry = SkillEntry()
)

data class SkillEntry(
    var isClassSkill: Boolean = false,
    var points: Int = 0,
    var abilityMod: Int = 0,
    var other: Int = 0,
    var total: Int = 0
)
