package com.example.exchangediary.model

data class DiaryEntry(
    val title: String,
    val content: String,
    val reactionEmoji: String? = null,
    val isTemporary: Boolean = false,
    val createdAt: Long = System.currentTimeMillis()
) {
    fun extractMoodTag(): String? {
        val lines = content.lines()
        for (line in lines) {
            if (line.startsWith("#mood:")) {
                return line.removePrefix("#mood:").trim()
            }
        }
        return null
    }

    fun extractCleanContent(): String {
        return content.lines()
            .filterNot { it.startsWith("#mood:") }
            .joinToString("\n")
            .trim()
    }

    fun isExpired(): Boolean {
        if (!isTemporary) return false
        val twentyFourHours = 24 * 60 * 60 * 1000L
        return System.currentTimeMillis() - createdAt > twentyFourHours
    }
}