package com.narendra.newsapplication.news_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.narendra.news_domain.model.News
import com.narendra.newsapplication.databinding.ViewHolderNewsListBinding

/**
 * RecyclerView Adapter to display news.
 */
class NewsListAdapter : RecyclerView.Adapter<NewsListAdapter.MyViewHolder>() {

    private var listener: ((News) -> Unit)? = null

    var list = mutableListOf<News>()
    /**
     * Method to update the data set of adapter.
     */
    fun setContentList(list: MutableList<News>) {
        this.list = list
        notifyDataSetChanged()
    }
    /**
     * RecyclerView ViewHolder to display a News item.
     *
     * @property viewHolder the binding class item layout.
     */
    class MyViewHolder(val viewHolder: ViewHolderNewsListBinding) : RecyclerView.ViewHolder(viewHolder.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding =
            ViewHolderNewsListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    fun itemClickListener(l: (News) -> Unit) {
        listener = l
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.viewHolder.news = this.list[position]

        holder.viewHolder.root.setOnClickListener {
            listener?.let { it(this.list[position]) }
        }
    }

    override fun getItemCount(): Int {
        return this.list.size
    }
}