package com.example.cse438.cse438_assignment2

import android.app.Application
import android.app.DownloadManager
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.cse438.cse438_assignment2.data.SearchPayload
import com.example.cse438.cse438_assignment2.data.TrackPayload

class SearchViewModel(application: Application): AndroidViewModel(application){
    public var searchList: MutableLiveData<SearchPayload> = MutableLiveData()
    public var SearchRepository: SearchRepository = SearchRepository()


    fun getSearchResponse(query: String){
        SearchRepository.getSearchResponse(searchList, query)
    }

}