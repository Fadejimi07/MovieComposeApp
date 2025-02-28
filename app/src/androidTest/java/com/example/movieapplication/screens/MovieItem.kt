package com.example.movieapplication.screens

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.example.movieapplication.retrofit.response.Movie
import org.junit.Rule
import org.junit.Test

class MovieItemTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun movieItemTest() {
        // Start the app
        composeTestRule.setContent {
            MovieItem(
                movie = Movie(
                    id = 123,
                    title = title,
                    body = description,
                    movieImg = movieImgUrl,
                )
            )
        }

        composeTestRule.onNodeWithText(title).assertIsDisplayed()

    }

    companion object {
        private const val title = "TITLE"
        private const val description = "Description"
        private const val movieImgUrl = "/48844884"
    }
}