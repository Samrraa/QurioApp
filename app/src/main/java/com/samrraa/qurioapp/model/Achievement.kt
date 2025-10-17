package com.samrraa.qurioapp.model

enum class Achievement(val title: String, val description: String) {
    QUIZ_ROOKIE("Quiz Rookie", "Awarded for completing your first quiz."),
    STREAK_STARTER("Streak Starter", "Awarded for answering 3 questions correctly in a row."),
    LUCKY_GUESS("Lucky Guess", "Awarded for correctly answering a particularly tough question."),
    EXPLORER("Explorer", "Awarded for playing a quiz in 5 different categories."),
    TRIVIA_CHAMP("Trivia Champ", "Awarded for finishing in first place in 10 quizzes."),
    COLLECTOR("Collector", "Awarded for unlocking 5 other achievements."),
    QUICK_THINKER("Quick Thinker", "Awarded for answering a question in under 3 seconds.")
}