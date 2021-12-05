package dev.amol.newsapp.ui.adapter_recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dev.amol.newsapp.R
import dev.amol.newsapp.databinding.ItemlayoutBinding
import dev.amol.newsapp.model.local.NewsData
import dev.amol.newsapp.model.remote.responsedata.Article

class NewsAdapter(
    private val articleList:ArrayList<NewsData>,
    private val newsItemClickListener: NewsItemClickListener
):RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    class NewsViewHolder(val itemLayoutBinding: ItemlayoutBinding,val newsItemClickListener: NewsItemClickListener):RecyclerView.ViewHolder(itemLayoutBinding.root){

        fun setData(newsData: NewsData){
            itemLayoutBinding.apply {
                // passing dataclass to data-binding layout
                articleData = newsData
                //setting image using glide
                Glide.with(ivItemNewsImg).load(newsData.urlToImage).into(ivItemNewsImg)
                // setting clickListener
                NewsCard.setOnClickListener {
                    newsItemClickListener.onNewsItemClicked(newsData)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context),
            R.layout.itemlayout,parent,false),newsItemClickListener)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val article = articleList[position]
        holder.setData(article)
    }

    override fun getItemCount(): Int {
        return articleList.size
    }
}