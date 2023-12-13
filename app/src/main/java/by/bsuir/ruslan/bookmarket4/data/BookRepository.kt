package by.bsuir.ruslan.bookmarket4.data

import androidx.lifecycle.LiveData
import kotlinx.coroutines.flow.Flow

class BookRepository(private val bookDao: BookDao) {

    val readAllData: LiveData<List<BookDb>> = bookDao.getAllBook()

    suspend fun insertItem(item: BookDb) = bookDao.insert(item)

    suspend fun deleteItem(item: BookDb) = bookDao.delete(item)

    suspend fun updateItem(item: BookDb) =bookDao.update(item)
}