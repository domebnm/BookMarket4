package by.bsuir.ruslan.bookmarket4.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.viewmodel.compose.viewModel
import by.bsuir.ruslan.bookmarket4.AppViewModel
import by.bsuir.ruslan.bookmarket4.BookItem
import by.bsuir.ruslan.bookmarket4.R
import by.bsuir.ruslan.bookmarket4.data.ItemsViewModel
import by.bsuir.ruslan.bookmarket4.network.NetworkViewModel
import by.bsuir.ruslan.bookmarket4.ui.items.AddImage
import by.bsuir.ruslan.bookmarket4.ui.items.BookCard
import by.bsuir.ruslan.bookmarket4.ui.items.SimpleList
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.merge
import java.util.Scanner

@SuppressLint("StateFlowValueCalledInComposition")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(
    appViewModel: AppViewModel = viewModel(),
    onKeyboardDone: () -> Unit,
){
    val list: MutableList<BookItem> = mutableListOf()
    list.add(0,BookItem(title ="qwe"))
    list.add(1,BookItem(title ="lll"))
    list.add(2,BookItem(title ="ascbj"))

    Surface(
        modifier = Modifier.fillMaxSize(),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ){
                OutlinedTextField(
                    value = appViewModel.userGuess,
                    singleLine = true,
                    shape = MaterialTheme.shapes.large,
                    onValueChange = { appViewModel.updateUserGuess(it) },
                    label = { Text("Enter a book name") },
                    isError = false,
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = { onKeyboardDone() }
                    )
                )
                IconButton(
                    modifier = Modifier,
                    onClick = {
                        appViewModel.getBooksNetwork()
                    },
                ) {
                    SearchImage()
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            SimpleList(list = appViewModel.listNet.value, isAdded = false)
        }
    }
}
@Composable
fun SearchImage(){
    Image(
        painter = painterResource(R.drawable.ic_search_net),
        contentDescription = "added in favorite",
        modifier = Modifier
            .size(48.dp)
    )
}

@Preview
@Composable
fun ViewSearchScreen(){
    SearchScreen(
        onKeyboardDone = { }
    )
}