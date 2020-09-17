package com.mt.githubbrowser.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.mt.githubbrowser.BR
import com.mt.githubbrowser.R
import com.mt.githubbrowser.databinding.ItemRepoBinding
import com.mt.githubbrowser.model.Repo

/**
 *  @author : MaoTong
 *  @date : 2020/9/17 10:56
 *  description :
 */

/**
 * ================================================
 *  @author : MaoTong
 *  @date : 2020/9/17 10:56
 *  description :
 * <a href="mailto:ytumaotong@gmail.com">Contact me</a>
 * <a href="https://github.com/Crazy-MT">Follow me</a>
 * ================================================
 */
class RepoItemAdapter() : RecyclerView.Adapter<RepoItemAdapter.ItemViewHolder>() {
    var repos: List<Repo>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = DataBindingUtil.inflate<ItemRepoBinding>(LayoutInflater.from(parent.context), R.layout.item_repo, parent,false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.viewBinding.setVariable(BR.repo, repos?.get(position))
        holder.viewBinding.repo = repos?.get(position)
        Log.e(TAG, ": MTMTMT " + repos?.size)
        holder.viewBinding.executePendingBindings()
    }

    override fun getItemCount(): Int {
        return repos?.size ?: 0
    }
    companion object {
        var TAG = "repo"
    }

    class ItemViewHolder(var viewBinding: ItemRepoBinding) : RecyclerView.ViewHolder(viewBinding.root) {

    }
}