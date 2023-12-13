package by.bsuir.ruslan.bookmarket4.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.NavHostController

import by.bsuir.ruslan.bookmarket4.ui.screens.HomeScreen
import by.bsuir.ruslan.bookmarket4.ui.screens.MyBookScreen
import by.bsuir.ruslan.bookmarket4.ui.screens.SearchScreen

@Composable
fun MyNavGraph(
    navController: NavHostController,
    modifier: Modifier
)
{
    NavHost(
        navController = navController,
        startDestination = NavigationItems.Home.route,
        modifier = modifier
    ) {
        composable(NavigationItems.Home.route) {
            HomeScreen()
        }

        composable(NavigationItems.Search.route) {
            SearchScreen(
                onKeyboardDone = { }
            )
        }

        composable(NavigationItems.MyBook.route){
            MyBookScreen()
        }
    }

}