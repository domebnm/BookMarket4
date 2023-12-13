package by.bsuir.ruslan.bookmarket4.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface BookDao {

    @Query("SELECT * FROM books")
    fun getAllBook(): LiveData<List<BookDb>>

    @Query("SELECT * FROM books WHERE favorite = :bool")
    fun getAllFavorite(bool: Boolean = true): LiveData<List<BookDb>>

    @Query("SELECT * from books WHERE id = :id")
    fun getItem(id: Int): LiveData<BookDb>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: BookDb)

    @Update
    suspend fun update(item: BookDb)

    @Delete
    suspend fun delete(item: BookDb)
}