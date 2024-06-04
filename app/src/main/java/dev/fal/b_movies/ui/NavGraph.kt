package dev.fal.b_movies.ui

import androidx.compose.runtime.Composable
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import dev.fal.b_movies.ui.presentation.screen.home.HomeScreen
import dev.fal.b_movies.ui.presentation.screen.movie.MovieScreen
import kotlin.random.Random

@Composable
fun SetupNavGraph(
    navController: NavHostController,
    startDestination: Screen = Screen.Home
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable<Screen.Home> {
            HomeScreen(
                onClick = {
                    navController.navigate(
                        Screen.Movie(id = Random.nextInt(10))
                    )
                }
            )
        }
        composable<Screen.Movie> { backStackEntry ->
            val movie = backStackEntry.toRoute<Screen.Movie>()
            MovieScreen(
                id = movie.id,
                onClick = {
                    if (navController.canGoBack) {
                        navController.popBackStack()
                    }
                }
            )
        }
    }
}

val NavHostController.canGoBack: Boolean
    get() = this.currentBackStackEntry?.lifecycle?.currentState == Lifecycle.State.RESUMED