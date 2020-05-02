package com.example.repoinfo.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.repoinfo.R
import com.example.repoinfo.model.UserDetails


class RepoListFragment : Fragment() {

    companion object {
        fun newInstance() = RepoListFragment()
    }

    private lateinit var viewModel: RepoListViewModel
    private lateinit var adapter: UserAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        super.onCreateView(inflater, container, savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(RepoListViewModel::class.java)
        viewModel.init()
        viewModel.getUserResponseLiveData()?.observe(viewLifecycleOwner, Observer<UserDetails>() {


            fun onChanged(userDetails: UserDetails) {
                if (userDetails != null) {
                    adapter.setResults(userDetails)
                }
            }
        })
        return inflater.inflate(R.layout.repo_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val recyclerView: RecyclerView =
            requireView().findViewById(R.id.recyclerViewUsers)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter

//        keywordEditText = view!!.findViewById(R.id.fragment_booksearch_keyword)
//       authorEditText = view!!.findViewById(R.id.fragment_booksearch_author)
//       searchButton = view!!.findViewById(R.id.fragment_booksearch_search)




    }


}


