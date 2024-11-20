package com.example.testsampleapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testsampleapplication.network.NetworkCall
import com.example.testsampleapplication.network.model.Quote

class MainActivity : AppCompatActivity() {

    var retrievedQuotes: List<Quote>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val recyclerView = findViewById<RecyclerView>(R.id.quote_list)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val quotesButton = findViewById<Button>(R.id.getQuotes)
        quotesButton.setOnClickListener {

            NetworkCall.getQuotes { listQuotes ->
                if(listQuotes != null) {
                    retrievedQuotes = listQuotes
                    val adapter = QuoteListAdapter(listQuotes)
                    recyclerView.adapter = adapter
                }
            }
        }

        val authorInput = findViewById<EditText>(R.id.author_input)

        val searchButton = findViewById<Button>(R.id.searchAuthor)

        searchButton.setOnClickListener {

            val searchText = authorInput.text.toString()

            val filteredList = retrievedQuotes?.filter { it.author.equals(searchText) }
            filteredList?.let {
                (recyclerView.adapter as QuoteListAdapter).updateData(it)
            }

        }

    }
}