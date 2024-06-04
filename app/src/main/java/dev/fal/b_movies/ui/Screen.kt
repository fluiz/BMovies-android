package dev.fal.b_movies.ui

import kotlinx.serialization.Serializable

@Serializable
sealed class Screen {
    @Serializable
    data object Home: Screen()

    @Serializable
    data class Movie(
        val id: Int
    ): Screen()
}