package com.example.networking

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.example.networking.entities.Post
import com.example.networking.retrofit.utils.RetrofitInstance
import retrofit2.HttpException
import java.io.IOException

const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        getAllPosts()
//        createNewPost()
        getHistoricalWeather()
    }

    private fun getAllPosts() {
        lifecycleScope.launchWhenCreated {
            val response = try {
                RetrofitInstance.postsApi.getPosts()
            } catch (e: IOException) {
                Log.e(TAG, "IOException, you might not have internet connection")
                return@launchWhenCreated
            } catch (e: HttpException) {
                Log.e(TAG, "IOException, you might not have internet connection")
                return@launchWhenCreated
            }
            if (response.isSuccessful && response.body() != null) {
                val postsList = response.body()
                Log.d(TAG, "Posts list: $postsList")
            } else {
                Log.e(TAG, "Request failed. Code: ${response.code()}, Error: ${response.message()}")
            }
        }
    }

    private fun getHistoricalWeather() {
        lifecycleScope.launchWhenCreated {
            val response = try {
                RetrofitInstance.weatherApi.getLastWeekWeather()
            } catch (e: IOException) {
                Log.e(TAG, "IOException, you might not have internet connection")
                return@launchWhenCreated
            } catch (e: HttpException) {
                Log.e(TAG, "IOException, you might not have internet connection")
                return@launchWhenCreated
            }
            if (response.isSuccessful && response.body() != null) {
                val historicalWeather = response.body()
                Log.d(TAG, "WeatherHistory: $historicalWeather")
            } else {
                Log.e(TAG, "Request failed. Code: ${response.code()}, Error: ${response.message()}")
            }
        }
    }

    private fun createNewPost() {
        lifecycleScope.launchWhenCreated {
            val response = try {
                RetrofitInstance.postsApi.createNewPost(Post("Content", "Title", 1))
            } catch (e: IOException) {
                Log.e(TAG, "IOException, you might not have internet connection")
                return@launchWhenCreated
            } catch (e: HttpException) {
                Log.e(TAG, "IOException, you might not have internet connection")
                return@launchWhenCreated
            }
            if (response.isSuccessful && response.body() != null) {
                val newPost = response.body()
                Log.d(TAG, "Response: $response")
                Log.d(TAG, "New Post: $newPost")
            } else {
                Log.e(TAG, "Request failed. Code: ${response.code()}, Error: ${response.message()}")
            }
        }
    }
}