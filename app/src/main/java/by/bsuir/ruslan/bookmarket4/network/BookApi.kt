package by.bsuir.ruslan.bookmarket4.network

import android.util.Log
import androidx.compose.ui.res.stringArrayResource
import by.bsuir.ruslan.bookmarket4.BookItem
import kotlinx.coroutines.flow.Flow
import org.json.JSONArray
import org.json.JSONObject
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import java.util.stream.Collectors

class BookApi {
    @Throws(IOException::class)
    fun execute(title: String): List<BookItem> {
        val url =
            URL("https://api.nytimes.com/svc/books/v3/reviews.json?title=$title&api-key=02lTcL3WgEd9681gHA9Sh8hoCYkPShcN")
        val connection = url.openConnection() as HttpURLConnection
        connection.requestMethod = "GET"
        connection.setRequestProperty("Accept", "application/json")
        BufferedReader(InputStreamReader(connection.inputStream)).use {
            val jsonString = it.lines().collect(Collectors.joining("\n"))
            val jsonObj: JSONObject = StringToJSONObject(jsonString)
            if(jsonObj.get("num_results") == 0) {
                Log.d("Internet", "empty")
                return listOf()
            }
            val jsonArray: JSONArray = jsonObj.getJSONArray("results")
            return readJSONObjects(jsonArray)
        }
    }
    @Throws(IOException::class)
    fun executeBest(title: String): List<BookItem> {
        val url =
            URL("https://api.nytimes.com/svc/books/v3/lists.json?list=hardcover-fiction&api-key=02lTcL3WgEd9681gHA9Sh8hoCYkPShcN")
        val connection = url.openConnection() as HttpURLConnection
        connection.requestMethod = "GET"
        connection.setRequestProperty("Accept", "application/json")
        BufferedReader(InputStreamReader(connection.inputStream)).use {
            val jsonString = it.lines().collect(Collectors.joining("\n"))
            val jsonObj: JSONObject = StringToJSONObject(jsonString)
            if(jsonObj.get("num_results") == 0) {
                Log.d("Internet", "empty")
                return listOf()
            }
            val jsonArray: JSONArray = jsonObj.getJSONArray("results")
            return readJSONObjects(jsonArray)
        }
    }
    private fun readJSONObjects(jsonArray: JSONArray): List<BookItem> {
        var mutableList: MutableList<BookItem> = mutableListOf()
        for(i in 0 until jsonArray.length()){
            val jsonBookItem: JSONObject = jsonArray.getJSONObject(i)
            mutableList.add(BookItem().Set(jsonBookItem))
        }
        return mutableList.toList()
    }
    private fun StringToJSONObject(jsonString: String?) : JSONObject{
        val jsonObj: JSONObject = JSONObject(jsonString.toString())
        return jsonObj
    }
}