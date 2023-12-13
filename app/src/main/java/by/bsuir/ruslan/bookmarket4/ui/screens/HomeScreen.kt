package by.bsuir.ruslan.bookmarket4.ui.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import by.bsuir.ruslan.bookmarket4.AppViewModel
import by.bsuir.ruslan.bookmarket4.BookItem
import by.bsuir.ruslan.bookmarket4.ui.items.BookCard
import by.bsuir.ruslan.bookmarket4.ui.items.SimpleList
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

@Composable
fun HomeScreen(appViewModel: AppViewModel = viewModel()){

    val list = appViewModel.list

    val isLoading by appViewModel.isLoading.collectAsState()
    val state = rememberSwipeRefreshState(isRefreshing = isLoading)
    
    Column {
        SwipeRefresh(
            state = state,
            onRefresh = appViewModel::loadStuff
        )
        {
            SimpleList(list = list, isAdded = false)
        }

    }
}
@Preview
@Composable
fun ViewHomeScreen(){
    HomeScreen()
}