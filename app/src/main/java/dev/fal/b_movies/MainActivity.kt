package dev.fal.b_movies

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import dev.fal.b_movies.ui.Screen
import dev.fal.b_movies.ui.SetupNavGraph
import dev.fal.b_movies.ui.theme.BMoviesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BMoviesTheme {
                val navController = rememberNavController()
                SetupNavGraph(
                    navController = navController,
                    startDestination = Screen.Home
                )
            }
        }
    }
}
