package com.example.testsampleapplication

import android.view.TextureView
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class QuoteViewHolder(quoteRowView: View): RecyclerView.ViewHolder(quoteRowView) {
    val authorLabel = quoteRowView.findViewById<TextView>(R.id.quote_author)
    val quoteLabel = quoteRowView.findViewById<TextView>(R.id.quote_description)
}