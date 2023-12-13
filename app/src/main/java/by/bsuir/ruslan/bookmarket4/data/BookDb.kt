package by.bsuir.ruslan.bookmarket4.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "books")
data class BookDb (
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "author")
    val author: String,
    @ColumnInfo(name = "summary")
    val summary: String,
    @ColumnInfo(name = "date")
    val date: String,
    @ColumnInfo(name = "favorite")
    val favorite: Boolean,
    @ColumnInfo(name = "comment")
    val comment: String,
)