package com.example.characterblank.data.model

data class Skills( // bloc "Г"
    var acrobatics: SkillEntry = SkillEntry(),
    var bluff: SkillEntry = SkillEntry(),
    var riding: SkillEntry = SkillEntry(),
    var attention: SkillEntry = SkillEntry(),
    var diplomacy: SkillEntry = SkillEntry(),

    var knowledgeGeography: SkillEntry = SkillEntry(),
    var knowledgeHistory: SkillEntry = SkillEntry(),
    var knowledgeLocal: SkillEntry = SkillEntry(),
    var knowledgeDungeons: SkillEntry = SkillEntry(),
    var knowledgeNature: SkillEntry = SkillEntry(),
    var knowledgeReligion: SkillEntry = SkillEntry(),
    var knowledgeMagic: SkillEntry = SkillEntry(),

    var witchcraft: SkillEntry = SkillEntry(),
    var climbing: SkillEntry = SkillEntry(),
    var healing: SkillEntry = SkillEntry(),
    var Mechanics: SkillEntry = SkillEntry(),
    var swimming: SkillEntry = SkillEntry(),
    var insight: SkillEntry = SkillEntry(),
    var stealth: SkillEntry = SkillEntry()
)

data class SkillEntry(
    var isClassSkill: Boolean = false,
    var points: Int = 0,
    var abilityMod: Int = 0,
    var other: Int = 0,
    var total: Int = 0
)