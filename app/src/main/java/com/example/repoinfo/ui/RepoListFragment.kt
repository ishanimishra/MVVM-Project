package com.example.repoinfo.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.repoinfo.R
import com.example.repoinfo.model.UserDetails
import com.example.repoinfo.network.UsersApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RepoListFragment : Fragment(), onUserItemClickListener {

    companion object {
        fun newInstance() = RepoListFragment()
    }

    private lateinit var viewModel: RepoListViewModel
    private lateinit var adapter: UserAdapter
    private val recyclerView: RecyclerView = requireView().findViewById(R.id.recyclerViewUsers)


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.repo_list_fragment, container, false)
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
//        val recyclerView: RecyclerView =
//            view.findViewById(R.id.recyclerViewUsers)
//        recyclerView.layoutManager = LinearLayoutManager(activity)
//        recyclerView.addItemDecoration(DividerItemDecoration(activity, 1))
//        recyclerView.adapter =
//            UserAdapter(users, this)
//        adapter = UserAdapter(List<UserDetails>,onUserItemClickListener{
//            viewModel.
//        })
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        fetchUsers()
//        recyclerView.layoutManager = LinearLayoutManager(context)
//        recyclerView.addItemDecoration(DividerItemDecoration(activity,1))
//        recyclerView.adapter = adapter


//        keywordEditText = view!!.findViewById(R.id.fragment_booksearch_keyword)
//       authorEditText = view!!.findViewById(R.id.fragment_booksearch_author)
//       searchButton = view!!.findViewById(R.id.fragment_booksearch_search)


    }

    private fun fetchUsers() {
        UsersApiService()
            .getProperties(5).enqueue(object : Callback<List<UserDetails>> {
                override fun onFailure(call: Call<List<UserDetails>>, t: Throwable) {
                    Toast.makeText(activity, t.message, Toast.LENGTH_LONG).show()
                }

                override fun onResponse(
                    call: Call<List<UserDetails>>,
                    response: Response<List<UserDetails>>
                ) {
                    val users = response.body()

                    users?.let {
                        showUsers(it)
                    }
                }
            })
    }

    private fun showUsers(users: List<UserDetails>) {
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.addItemDecoration(DividerItemDecoration(activity, 1))
        adapter = UserAdapter(users,this)
        recyclerView.adapter =
            this.adapter
    }


}


