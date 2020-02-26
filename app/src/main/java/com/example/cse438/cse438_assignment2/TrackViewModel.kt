package com.example.cse438.cse438_assignment2

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.cse438.cse438_assignment2.data.TrackPayload
import com.example.cse438.cse438_assignment2.network.TracksRepository

class TrackViewModel(application: Application): AndroidViewModel(application){
    public var trackList: MutableLiveData<TrackPayload> = MutableLiveData()
    public var tracksRepository: TracksRepository = TracksRepository()

    fun getChartTracks(){
        tracksRepository.getChartTracks(trackList)
    }

}