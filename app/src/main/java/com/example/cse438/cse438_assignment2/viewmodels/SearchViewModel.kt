package com.example.cse438.cse438_assignment2.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.cse438.cse438_assignment2.repositories.SearchRepository
import com.example.cse438.cse438_assignment2.data.SearchPayload


class SearchViewModel(application: Application): AndroidViewModel(application){
    public var searchList: MutableLiveData<SearchPayload> = MutableLiveData()
    public var SearchRepository: SearchRepository =
        SearchRepository()


    fun getSearchResponse(query: String){
        SearchRepository.getSearchResponse(searchList, query)
    }

}