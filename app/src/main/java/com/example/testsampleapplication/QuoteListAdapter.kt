package com.example.testsampleapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.testsampleapplication.network.model.Quote

class QuoteListAdapter(private var quoteList: List<Quote>): RecyclerView.Adapter<QuoteViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteViewHolder {
       val view = LayoutInflater.from(parent.context)
           .inflate(R.layout.quote_row, parent, false)
        return QuoteViewHolder(view)
    }

    override fun getItemCount(): Int {
       return quoteList.size
    }

    override fun onBindViewHolder(holder: QuoteViewHolder, position: Int) {
       val quoteItem = quoteList.get(position)
        holder.quoteLabel.text = quoteItem.quote
        holder.authorLabel.text = quoteItem.author
    }

    fun updateData(quoteList: List<Quote>) {
        this.quoteList = quoteList
        notifyDataSetChanged()
    }

}