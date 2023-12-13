package by.bsuir.ruslan.bookmarket4.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import by.bsuir.ruslan.bookmarket4.BookItem

@Database(entities = [BookDb::class], version = 1, exportSchema = false)
abstract class BookDatabase: RoomDatabase() {

    abstract fun getDao(): BookDao

    companion object{
        @Volatile
        private var Instance: BookDatabase? = null

        fun getDatabase(context: Context): BookDatabase{
            return Room.databaseBuilder(
                context.applicationContext,
                BookDatabase::class.java,
                "book.db"
            ).createFromAsset("database/book.db")
                .build()
        }
    }
}