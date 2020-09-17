package com.mt.githubbrowser.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.mt.githubbrowser.BR
import com.mt.githubbrowser.R
import com.mt.githubbrowser.databinding.ItemRepoBinding
import com.mt.githubbrowser.model.Repo

/**
 * ================================================
 *  @author : MaoTong
 *  @date : 2020/9/17 10:56
 *  description :
 * <a href="mailto:ytumaotong@gmail.com">Contact me</a>
 * <a href="https://github.com/Crazy-MT">Follow me</a>
 * ================================================
 */
class RepoItemAdapter(var repos: List<Repo>?) : RecyclerView.Adapter<RepoItemAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = DataBindingUtil.inflate<ItemRepoBinding>(LayoutInflater.from(parent.context), R.layout.item_repo, parent,false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.viewBinding.setVariable(BR.repo, repos?.get(position))
        holder.viewBinding.executePendingBindings()

        holder.viewBinding.name.setOnClickListener {
            repos?.get(position)?.name = "click" + position
            Log.e(TAG, ": MTMTMT " + "click" + " " + repos?.get(position)?.name);
        }
    }

    override fun getItemCount(): Int {
        return repos?.size ?: 0
    }
    companion object {
        var TAG = "repo"
    }

    class ItemViewHolder(var viewBinding: ItemRepoBinding) : RecyclerView.ViewHolder(viewBinding.root)
}