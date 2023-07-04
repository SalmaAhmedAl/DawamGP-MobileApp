package com.example.dawam.ui.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.dawam.R
import com.example.dawam.api.ApiManager
import com.example.dawam.api.model.waqfResponse.WaqfResponse
import com.example.dawam.databinding.FragmentHomeBinding
import com.example.dawam.ui.home.recycler_view.WaqfAdapter
import com.example.dawam.ui.waqf_details.WaqfDetailsActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment:Fragment() {
    lateinit var viewModel: HomeViewModel
    lateinit var viewBinding :FragmentHomeBinding
    lateinit var adapter: WaqfAdapter
    lateinit var searchView : SearchView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //init viewModel
        viewModel= ViewModelProvider(this).get(HomeViewModel::class.java)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        viewBinding= FragmentHomeBinding.inflate(inflater,container, false )
        return viewBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        loadAwqafListInHome()
        searchView =viewBinding.searchBar
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                if (!query.isNullOrEmpty()) {
                    searchWaqf(query)
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        }
        )
        }

    private fun searchWaqf(query: String) {
        showLoadingLayout()
        ApiManager.getApis().getSearch(query).enqueue(object:Callback<ArrayList<WaqfResponse>>{
            override fun onResponse(
                call: Call<ArrayList<WaqfResponse>>,
                response: Response<ArrayList<WaqfResponse>>
            ) {
                viewBinding.content.loadingIndicator.isVisible=false
                if(response.isSuccessful){
                    Log.e("onResponse: result is ", response.body().toString())
                    val newAwqaf = response.body()
                   newRecyclerView(newAwqaf)
                }
            }

            override fun onFailure(call: Call<ArrayList<WaqfResponse>>, t: Throwable) {
                viewBinding.content.loadingIndicator.isVisible=false
                showErrorLayout(t.localizedMessage as String)
                Log.e("onFailure: false",t.localizedMessage)

            }

        })

    }

    private fun loadAwqafListInHome() {

        showLoadingLayout()
        //get Awqaf
        ApiManager.getApis().getWaqf().enqueue(object :Callback<ArrayList<WaqfResponse>>{
            override fun onResponse(
                call: Call<ArrayList<WaqfResponse>>,
                response: Response<ArrayList<WaqfResponse>>
            ) {
                viewBinding.content.loadingIndicator.isVisible=false
                if(response.isSuccessful){
                    val awqaf = response.body()
                    initRecyclerView(awqaf)

                }
            }
            override fun onFailure(call: Call<ArrayList<WaqfResponse>>, t: Throwable) {
                viewBinding.content.loadingIndicator.isVisible=false
                showErrorLayout(t.localizedMessage as String)
            }

        })

    }

    private fun initRecyclerView(awqaf:ArrayList<WaqfResponse>?) {
        adapter = WaqfAdapter(awqaf)
        adapter.onWaqfClick = object : WaqfAdapter.OnWaqfClick {
            override fun onWaqfBtnClick(id: Int) {
                //We should start new activity ==> WaqfRequest details
                val intent = Intent(requireActivity(), WaqfDetailsActivity::class.java)
                intent.putExtra("ID", id)
                startActivity(intent)
            }
        }
        viewBinding.content.waqfRecycler.adapter=adapter
    }
    private fun newRecyclerView(newAwqaf:ArrayList<WaqfResponse>?){
        adapter = WaqfAdapter(newAwqaf)
        adapter.onWaqfClick = object : WaqfAdapter.OnWaqfClick {
            override fun onWaqfBtnClick(id: Int) {
                //We should start new activity ==> WaqfRequest details
                val intent = Intent(requireActivity(), WaqfDetailsActivity::class.java)
                intent.putExtra("ID", id)
                startActivity(intent)
            }
        }
        viewBinding.content.waqfRecycler.adapter=adapter
    }

    private fun showLoadingLayout() {
        viewBinding.content.errorLayout.isVisible=false
        viewBinding.content.loadingIndicator.isVisible=true
    }

    private fun showErrorLayout(errorMessage:String) {
        viewBinding.content.errorLayout.isVisible=true
        viewBinding.content.loadingIndicator.isVisible=false
        viewBinding.content.errorMessage.text= errorMessage
        viewBinding.content.tryAgainBtn.setOnClickListener{
            loadAwqafListInHome()
        }
    }

}