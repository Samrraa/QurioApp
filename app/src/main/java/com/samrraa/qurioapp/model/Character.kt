package com.samrraa.qurioapp.model

enum class Character(
    val displayName: String,
    val age: Int,
    val power: String,
    val description: String
) {
    RIKA(
        displayName = "Rika",
        age = 12,
        power = "Sunblooms",
        description = "Nature’s little explorer! Rika talks to mushrooms and swears squirrels give her battle advice. Always ready for an adventure."
    ),

    KAIYO(
        displayName = "Kaiyo",
        age = 14,
        power = "Storms",
        description = "A calm storm in human form. Kaiyo trains with ancient scrolls by day and drinks spicy tea by night. Sword sharp, heart sharper."
    ),

    MIMI(
        displayName = "Mimi",
        age = 10,
        power = "Volcano Puffs",
        description = "Tiny but terrifying! Mimi is always grumpy, but don’t let that scare you—unless you like pranks involving firecrackers."
    ),

    YORU(
        displayName = "Yoru",
        age = 13,
        power = "Shadows",
        description = "Quiet, mysterious, and probably watching you right now. Yoru shows up when you least expect it."
    ),

    KURO(
        displayName = "Kuro",
        age = 15,
        power = "Thunder Beats",
        description = "Cool jacket, cooler moves. Kuro never backs down from a challenge."
    ),

    MIKO(
        displayName = "Miko",
        age = 11,
        power = "Leaf Turns",
        description = "Energetic, cheerful, and faster than a leaf in the wind. Miko can turn any trivia into a giggle-fest."
    ),

    AORI(
        displayName = "Aori",
        age = 13,
        power = "Blade Echoes",
        description = "The sword chooses the wielder—and it chose Aori. Calm, focused."
    ),

    NARA(
        displayName = "Nara",
        age = 12,
        power = "Crystal Songs",
        description = "Part magic, part sass. Nara sparkles even when she’s mad."
    ),

    RENJI(
        displayName = "Renji",
        age = 11,
        power = "Hero Coins",
        description = "Small but mighty! Renji dreams of glory, carries a shield too big for him."
    )
}