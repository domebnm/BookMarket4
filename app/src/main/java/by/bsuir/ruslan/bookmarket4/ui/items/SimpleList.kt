package by.bsuir.ruslan.bookmarket4.ui.items

import android.util.Log
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import by.bsuir.ruslan.bookmarket4.BookItem

@Composable
fun SimpleList(list: List<BookItem>, isAdded: Boolean) {
    LazyColumn(modifier = Modifier
        .width(350.dp)
        .height(500.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        items(items = list) {
            Spacer(modifier = Modifier.padding(2.dp))
            if(isAdded)BookCard(it)
            else BookCardAdd(bookItem = it)
        }
    }
}