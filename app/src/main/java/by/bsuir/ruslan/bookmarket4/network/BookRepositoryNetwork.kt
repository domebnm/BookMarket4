package by.bsuir.ruslan.bookmarket4.network

class BookRepositoryNetwork {
    suspend fun getBooks(title: String) = BookApi().execute(title)
}