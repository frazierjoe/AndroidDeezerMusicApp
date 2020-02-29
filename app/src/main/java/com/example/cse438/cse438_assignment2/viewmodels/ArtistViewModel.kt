package com.example.cse438.cse438_assignment2.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.cse438.cse438_assignment2.data.Artist
import com.example.cse438.cse438_assignment2.repositories.ArtistRepository
import com.example.cse438.cse438_assignment2.data.ArtistPayload

class ArtistViewModel(application: Application): AndroidViewModel(application){
    public var artistList: MutableLiveData<ArtistPayload> = MutableLiveData()
    public var artist: MutableLiveData<Artist> = MutableLiveData()
    public var artistRepository: ArtistRepository =
        ArtistRepository()

    fun getSearchArtist(input: String){
        artistRepository.getSearchArtist(artistList, input)
    }
    fun getArtist(input: String){
        artistRepository.getArtist(artist,input)
    }
}