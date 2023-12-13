package by.bsuir.ruslan.bookmarket4

import android.app.Application
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import by.bsuir.ruslan.bookmarket4.data.BookDatabase
import by.bsuir.ruslan.bookmarket4.data.BookDb
import by.bsuir.ruslan.bookmarket4.network.BookApi
import by.bsuir.ruslan.bookmarket4.network.BookRepositoryNetwork
import by.bsuir.ruslan.bookmarket4.network.NetworkViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AppViewModel(
    application: Application,
): AndroidViewModel(application) {

    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()

    init {
        loadStuff()
    }

    fun loadStuff(){
        viewModelScope.launch {
            _isLoading.value = true
            delay(1000L)
            _isLoading.value = false
        }
    }


    private val repository: BookRepositoryNetwork

    val list: MutableList<BookItem> = mutableListOf()

    //private var listN: MutableList<BookItem> =
    val listNet = MutableStateFlow(mutableListOf<BookItem>())
    var kkkk = listNet.asStateFlow()

    val listBestNet = MutableStateFlow(mutableListOf<BookItem>())

    init {
        list.add(0,BookItem(title = "qwe"))
        list.add(1,BookItem(title = "lll"))
        list.add(2,BookItem(title = "ascbj"))
        //getBookNetwork(" ")
        repository = BookRepositoryNetwork()
    }

    private val _uiState = MutableStateFlow("")
    var uiState: StateFlow<String> = _uiState.asStateFlow()

    var userGuess by mutableStateOf("")
        private set

    fun updateUserGuess(guessedWord: String){
        userGuess = guessedWord
    }
    fun updateList(){
        viewModelScope.launch {
            listNet.value.add(BookItem(title = "ascbj"))
        }
    }
    fun getBooksNetwork(){
        viewModelScope.launch(Dispatchers.IO) {
            val listt = repository.getBooks(userGuess)

            if(listt.size > 0) {
                listNet.value = listt.toMutableList()
            }
            else{listNet.value = mutableListOf<BookItem>() }
        }
    }
    fun getBestNetwork(){
        viewModelScope.launch(Dispatchers.IO) {
            val listt = repository.getBooks(userGuess)

            if(listt.size > 0) {
                listNet.value = listt.toMutableList()
            }
            else{listNet.value = mutableListOf<BookItem>() }
        }
    }
//    fun getBookNetwork(search: String){
//        //Thread{ searchlist = BookApi().execute("1Q84")}.start()
//        viewModelScope.launch {
//            try {
//                searchlist = BookApi().execute("1Q84")
//                Log.d("LaunchViewModelScope", "${searchlist?.size}")
//            } catch (e: Exception) {
//                Log.d("InternetException", e.toString())
//            }
//        }
//    }
//    fun updateCard(book: BookItem){
//        for(i in list){
//            if(i.title!! == book.title && i.author!! == book.author){
//                i.favorite = book.favorite//i.Set(book)
//                _uiState.value =
//                break
//            }
//        }
//    }
}