package by.bsuir.ruslan.bookmarket4.network

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NetworkViewModel: ViewModel() {

    private val repository: BookRepositoryNetwork

    init{
        repository = BookRepositoryNetwork()
    }

    fun getBooks(title: String){
        viewModelScope.launch(Dispatchers.IO) {
            repository.getBooks(title)
        }
    }
}