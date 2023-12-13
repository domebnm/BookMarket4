package by.bsuir.ruslan.bookmarket4

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import by.bsuir.ruslan.bookmarket4.data.BookDb
import by.bsuir.ruslan.bookmarket4.data.ItemsViewModel
import by.bsuir.ruslan.bookmarket4.ui.screens.MainScreen
import by.bsuir.ruslan.bookmarket4.ui.theme.BookMarket4Theme

class MainActivity : ComponentActivity() {

    private lateinit var mBookViewModel: ItemsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBookViewModel = ViewModelProvider(this).get(ItemsViewModel::class.java)
        //Log.d("Database","size: ${list}")


        setContent {
            BookMarket4Theme(darkTheme = true) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }
    private fun insertDataToDatabases(){
        val bookDb = BookDb(null,"asd",
            "jk", "jjh", "klj",
            false, "hj")

        mBookViewModel.insertBook(bookDb)
    }
}
//        val book = BookDb(null, "title", "author",
//            "summary","date",true,"comment")
//
//        val db = BookDatabase.getDatabase(this)
//
//        Thread{
//            db.getDao().addBook(book = book)
//        }.start()
//        GlobalScope.launch {
//            try {
//                var searchlist = BookApi().execute("1Q84")
//                Log.d("LaunchViewModelScope", "${searchlist?.size}")
//            } catch (e: Exception) {
//                Log.d("InternetException", e.toString())
//        }
//    }
//    Thread {
//        var ar = BookApi().execute("1Q84")
//            Log.d("Internet",ar.toString())
//        }.start()
//        Thread{
//            val list: MutableList<BookItem>? = BookApi().execute("1Q84")
//            Log.d("Internet", " asd ${list?.size}")
//        }.start()

//val book = BookDb(null, "title", "author",
//"summary","date",true,"comment")
//        Thread{
//            val db = BookDatabase.getDatabase(this)
//
//            //db.getDao().addBook(book = book)
//        }.start()