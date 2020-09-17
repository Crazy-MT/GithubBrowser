package com.mt.githubbrowser

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mt.githubbrowser.adapter.RepoItemAdapter
import com.mt.githubbrowser.databinding.ActivityMainBinding
import com.mt.githubbrowser.model.Repo
import com.mt.githubbrowser.viewmodel.RepoViewModel

class MainActivity : AppCompatActivity() {

    var binding: ActivityMainBinding? = null
    var viewModel: RepoViewModel = RepoViewModel()
    var adapter: RepoItemAdapter = RepoItemAdapter()

    companion object {
        private const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding?.viewmodel = viewModel
        binding?.lifecycleOwner = this

        initSerarchInputListener()

        initRepoRecyclerView()
    }

    private fun initRepoRecyclerView() {
        binding?.repoList?.adapter = adapter
        viewModel.repoSearchResp.observe(this, {
            Log.e(TAG, ": MTMTMT " + it.total)
            adapter.repos = it.items
            adapter.notifyDataSetChanged()
        })
    }

    private fun initSerarchInputListener() {
        binding?.input?.setOnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                doSearch(v)
                true
            } else {
                false
            }
        }

        binding?.input?.setOnKeyListener { v, keyCode, event ->
            if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                doSearch(v)
                true
            } else {
                false
            }
        }
    }

    private fun doSearch(v: View) {
        val query = binding?.input?.text.toString()
        dismissKeyboard(v.windowToken)
        // viewModel 查询
        viewModel.search(query)
    }

    private fun dismissKeyboard(windowToken: IBinder?) {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
        imm?.hideSoftInputFromWindow(windowToken, 0)
    }
}