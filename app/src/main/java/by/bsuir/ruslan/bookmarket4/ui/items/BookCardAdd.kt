package by.bsuir.ruslan.bookmarket4.ui.items

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import by.bsuir.ruslan.bookmarket4.AppViewModel
import by.bsuir.ruslan.bookmarket4.BookItem
import by.bsuir.ruslan.bookmarket4.R
import by.bsuir.ruslan.bookmarket4.data.ItemsViewModel
import by.bsuir.ruslan.bookmarket4.ui.screens.SearchScreen

@Composable
fun BookCardAdd(
    bookItem: BookItem,
    appViewModel: AppViewModel = viewModel(),
    mBookViewModel: ItemsViewModel = viewModel(
        modelClass = ItemsViewModel::class.java
    )
) {
    Card(
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier
            //.background(MaterialTheme.colorScheme.background)
            .height(100.dp)
            .width(300.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Spacer for separation
            // Text content on the right
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(80.dp)
            ) {
                Text(
                    text = bookItem.title!!,
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = bookItem.author!!,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(130.dp)
            ) {
                Text(
                    text = bookItem.summary!!,
                    softWrap = true,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                )
                Text(
                    text = bookItem.date!!,
                    textAlign = TextAlign.Right,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                )
            }
            Spacer(modifier = Modifier.width(10.dp))

            IconButton(
                modifier = Modifier.size(80.dp),
                onClick = {
                    mBookViewModel.insertBook(bookItem.GetBookDb())
                },
            ) {
                AddImage()
            }

        }
    }
}
@Composable
fun AddImage(){
    Image(
        painter = painterResource(R.drawable.ic_add),
        contentDescription = "added in favorite",
        modifier = Modifier
            .size(48.dp)
    )
}

@Preview
@Composable
fun ViewBookCardAdd(){
    BookCard(BookItem())
}

