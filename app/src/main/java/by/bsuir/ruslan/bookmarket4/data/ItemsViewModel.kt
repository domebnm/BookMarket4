package by.bsuir.ruslan.bookmarket4.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ItemsViewModel(application: Application) : AndroidViewModel(application) {

    val readAllBook: LiveData<List<BookDb>>
    //val readAllFavorite: LiveData<List<BookDb>>
    private val repository: BookRepository
    init{
        val bookDao = BookDatabase.getDatabase(application).getDao()
        repository= BookRepository(bookDao)
        readAllBook = repository.readAllData
        //readAllFavorite = repository.readAllFavorite
    }

    fun insertBook(bookDb: BookDb){
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertItem(bookDb)
        }
    }
    fun updateBook(bookDb: BookDb){
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateItem(bookDb)
        }
    }
    fun deleteBook(bookDb: BookDb){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteItem(bookDb)
        }
    }
//    val uiState: StateFlow<UiState> = readAllBook
//            .stateIn(
//                scope = viewModelScope,
//                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
//                initialValue = HomeUiState()
//            )
}
data class UiState(val itemList: List<BookDb> = listOf())