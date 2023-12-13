package by.bsuir.ruslan.bookmarket4.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import by.bsuir.ruslan.bookmarket4.R
import by.bsuir.ruslan.bookmarket4.ui.navigation.MyNavGraph
import by.bsuir.ruslan.bookmarket4.ui.navigation.NavigationItems

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {

    val navController = rememberNavController()

    Scaffold (
        topBar = {},
        bottomBar = {
            BottomBar(navController)
        }
    ){
        MyNavGraph(navController = navController, modifier = Modifier.padding(it))
    }
}

@Composable
fun BottomBar(navController: NavController){

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar {
        NavigationBarItem(
            selected = currentDestination?.hierarchy?.any { it.route == NavigationItems.Home.route } == true,
            onClick = { navController.navigate(NavigationItems.Home.route){
                popUpTo(navController.graph.findStartDestination().id) {
                    saveState = true
                }
                launchSingleTop = true
                restoreState = true
            } },
            label = { Text(text = "Home") },
            icon = { Icon(imageVector = ImageVector.vectorResource(R.drawable.ic_home),
                contentDescription = "")
            })
        NavigationBarItem(
            selected = currentDestination?.hierarchy?.any { it.route == NavigationItems.Search.route } == true,
            onClick = { navController.navigate(NavigationItems.Search.route){
                popUpTo(navController.graph.findStartDestination().id) {
                    saveState = true

                }
                launchSingleTop = true
                restoreState = true
            } },
            label = { Text(text = "Search") },
            icon = { Icon(imageVector = ImageVector.vectorResource(R.drawable.ic_search),
                contentDescription = "")
            })
        NavigationBarItem(
            selected = currentDestination?.hierarchy?.any { it.route == NavigationItems.MyBook.route } == true,
            onClick = { navController.navigate(NavigationItems.MyBook.route){
                popUpTo(navController.graph.findStartDestination().id) {
                    saveState = true
                }
                restoreState = true
            } },
            label = { Text(text = "MyBook") },
            icon = { Icon(imageVector = ImageVector.vectorResource(R.drawable.ic_books),
                contentDescription = "")
            })
    }
}