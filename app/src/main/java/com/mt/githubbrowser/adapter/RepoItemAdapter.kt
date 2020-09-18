package com.mt.githubbrowser.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingComponent
import androidx.databinding.DataBindingUtil
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.mt.githubbrowser.BR
import com.mt.githubbrowser.R
import com.mt.githubbrowser.common.DataBoundListAdapter
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
class RepoItemAdapter(
    private val showFullName: Boolean,
    private val repoClickCallback: ((Repo) -> Unit)?
) :
    DataBoundListAdapter<Repo, ItemRepoBinding>(
        object : DiffUtil.ItemCallback<Repo>() {
            override fun areItemsTheSame(oldItem: Repo, newItem: Repo): Boolean {
                return oldItem.owner == newItem.owner
                        && oldItem.name == newItem.name
            }

            override fun areContentsTheSame(oldItem: Repo, newItem: Repo): Boolean {
                return oldItem.description == newItem.description
                        && oldItem.stars == newItem.stars
            }
        }
    ) {

    override fun createBinding(parent: ViewGroup): ItemRepoBinding {

        val binding =  DataBindingUtil.inflate<ItemRepoBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_repo,
            parent,
            false
        )
        binding.showFullName = showFullName
        binding.root.setOnClickListener{
            binding.repo?.let {
                repoClickCallback?.invoke(it)
            }
        }
        return binding
    }

    override fun bind(binding: ItemRepoBinding, item: Repo) {
        binding.repo = item
    }

    companion object {
        var TAG = "repo"
    }
}