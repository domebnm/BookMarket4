package by.bsuir.ruslan.bookmarket4

import android.util.Log
import by.bsuir.ruslan.bookmarket4.data.BookDb
import org.json.JSONObject

data class BookItem(
    var id: Int? = null,
    var title: String? = "nothing",
    var author: String? = "unknown",
    var summary: String? = "nothing",
    var date: String? = "unknown",
    var favorite: Boolean? = false,
    var comment: String? = "empty",
) {
    fun Set(o: JSONObject): BookItem{
        title = o.get("book_title") as String
        author = o.get("book_author") as String
        summary = o.get("summary") as String
        date = o.get("publication_dt") as String
        return this
    }
    fun Set(bookDb: BookDb): BookItem{
        id = bookDb.id
        title = bookDb.title
        author = bookDb.author
        summary = bookDb.summary
        date = bookDb.date
        favorite = bookDb.favorite
        comment = bookDb.comment
        return this
    }
    fun Set(bookItem: BookItem): BookItem{
        id = bookItem.id
        title = bookItem.title
        author = bookItem.author
        summary = bookItem.summary
        date = bookItem.date
        favorite = bookItem.favorite
        comment = bookItem.comment
        return this
    }
    fun GetBookDb(): BookDb {
        val bookDb = BookDb(
            id = id,
            title = title!!,
            author = author!!,
            summary = summary!!,
            date = date!!,
            favorite = favorite!!,
            comment = comment!!
        )
        Log.d("GetBookDb", "${bookDb.id}, ${bookDb.title}")
        return bookDb
    }
    fun Set(list: List<BookDb>): List<BookItem>{
        val books = mutableListOf<BookItem>()
        for (i in list){
            books.add(BookItem().Set(i))
        }
        return books.toList()
    }
}