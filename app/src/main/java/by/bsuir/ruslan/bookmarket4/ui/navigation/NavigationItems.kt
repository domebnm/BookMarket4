package by.bsuir.ruslan.bookmarket4.ui.navigation

import by.bsuir.ruslan.bookmarket4.R

sealed class NavigationItems(var route: String, var icon: Int, var title: String){
    object Home : NavigationItems("home", R.drawable.ic_home, "Home")
    object Search : NavigationItems("search", R.drawable.ic_search, "Search")
    object MyBook : NavigationItems("myBook", R.drawable.ic_books, "myBook")
}