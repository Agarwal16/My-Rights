package com.example.myrights.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.myrights.API.ApiService
import com.example.myrights.adapters.NewsAdapter
import com.example.myrights.model.NewsResponse
import com.example.myrights.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NewsFragment : Fragment() {

    private lateinit var swipeRefreshLayout: SwipeRefreshLayout
    private lateinit var recyclerView: RecyclerView
    private lateinit var newsAdapter: NewsAdapter

    private val apiKey = "cf5323644f0e4d619dafea5a0e9ea10c" // Replace with your NewsAPI API key
    private var category = "human"
    private val pageSize = 20
    private var page = 1

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_news, container, false)

        swipeRefreshLayout = view.findViewById(R.id.swipeRefreshLayout)
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        newsAdapter = NewsAdapter(emptyList())
        recyclerView.adapter = newsAdapter

        swipeRefreshLayout.setColorSchemeResources(R.color.status_bar_color)
        swipeRefreshLayout.setOnRefreshListener {
            loadNews()
        }

        val latestButton = view.findViewById<Button>(R.id.scButton)
        val oldestButton = view.findViewById<Button>(R.id.rightsButton)

        latestButton.setOnClickListener {
            category = "supreme_court"
            page = 1
            loadNews()
        }

        oldestButton.setOnClickListener {
            category = "human_rights"
            page = 1
            loadNews()
        }

        loadNews()

        return view
    }

    private fun loadNews() {
        swipeRefreshLayout.isRefreshing = true

        val retrofit = Retrofit.Builder()
            .baseUrl("https://newsapi.org/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiService = retrofit.create(ApiService::class.java)

        val call = apiService.getNews(category, apiKey, pageSize.toString())

        call.enqueue(object : Callback<NewsResponse> {
            override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
                if (response.isSuccessful) {
                    val newsResponse = response.body()
                    val newsList = newsResponse?.articles ?: emptyList()
                    newsAdapter.updateData(newsList)

                    Log.d("API Success", "News count: ${newsList.size}")
                } else {
                    Log.e("API Error", response.message())
                }
                swipeRefreshLayout.isRefreshing = false
            }

            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                val errorMessage = t.message ?: "Unknown error occurred"
                Log.e("API Failure", errorMessage)
                swipeRefreshLayout.isRefreshing = false
            }
        })
    }
    companion object {
        @JvmStatic
        fun newInstance() = NewsFragment()
    }
}
