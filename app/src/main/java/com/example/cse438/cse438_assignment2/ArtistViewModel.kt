package com.example.cse438.cse438_assignment2

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.cse438.cse438_assignment2.data.ArtistPayload

class ArtistViewModel(application: Application): AndroidViewModel(application){
    public var artistList: MutableLiveData<ArtistPayload> = MutableLiveData()
    public var artistRepository: ArtistRepository = ArtistRepository()

    fun getSearchArtist(input: String){
        artistRepository.getSearchArtist(artistList, input)
    }
}