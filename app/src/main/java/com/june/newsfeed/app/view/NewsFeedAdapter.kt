package com.june.newsfeed.app.view

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.june.newsfeed.app.R
import com.june.newsfeed.app.databinding.NewsFeedItemLayoutBinding
import com.june.newsfeed.app.viewModel.NewsFeedViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.news_feed_item_layout.view.*

class NewsFeedAdapter(
    private val viewModel: NewsFeedViewModel,
    private val context: Context,
    private val clickListener: ItemClickListener
) : RecyclerView.Adapter<NewsFeedAdapter.NewsFeedViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): NewsFeedViewHolder {
        return NewsFeedViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.news_feed_item_layout,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return try {
            viewModel.newsFeedLiveData.value?.articles?.size!!
        } catch (e: KotlinNullPointerException) {
            0
        }
    }

    override fun onBindViewHolder(viewHolder: NewsFeedViewHolder, position: Int) {
        viewHolder.itemLayoutBinding.viewModel = viewModel
        viewHolder.itemLayoutBinding.position = position
        if (viewModel.getArticleAtIndex(position) != null && !viewModel.getArticleAtIndex(position)?.urlToImage.isNullOrBlank()) {
            Picasso.with(context).load(viewModel.getArticleAtIndex(position)?.urlToImage)
                .into(viewHolder.itemView.news_feed_item_imv)
        }

        viewHolder.itemView.setOnClickListener { clickListener.onItemClicked(position) }

    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    class NewsFeedViewHolder(val itemLayoutBinding: NewsFeedItemLayoutBinding) :
        RecyclerView.ViewHolder(itemLayoutBinding.root)

    interface ItemClickListener {
        fun onItemClicked(position: Int)
    }
}