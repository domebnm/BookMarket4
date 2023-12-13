package by.bsuir.ruslan.bookmarket4.ui.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import by.bsuir.ruslan.bookmarket4.AppViewModel
import by.bsuir.ruslan.bookmarket4.BookItem
import by.bsuir.ruslan.bookmarket4.data.BookDb
import by.bsuir.ruslan.bookmarket4.data.ItemsViewModel
import by.bsuir.ruslan.bookmarket4.ui.items.BookCard
import by.bsuir.ruslan.bookmarket4.ui.items.SimpleList

@Composable
fun MyBookScreen(
    appViewModel: AppViewModel = viewModel(
        modelClass = AppViewModel::class.java
    ),
    mBookViewModel: ItemsViewModel = viewModel(
        modelClass = ItemsViewModel::class.java
    )
){
    val items = mBookViewModel.readAllBook.observeAsState(listOf()).value
    Log.d("Database","size items: ${items.size}")
    val list = BookItem().Set(items)

    Text(text = "MyBookScreen", modifier = Modifier
        .wrapContentWidth()
        .background(Color.Black))
    SimpleList(list = list, isAdded = true)
}