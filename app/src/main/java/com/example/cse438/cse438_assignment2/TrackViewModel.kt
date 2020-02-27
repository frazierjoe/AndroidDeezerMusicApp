package com.example.cse438.cse438_assignment2

import android.app.Application
import android.app.RemoteInput
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.cse438.cse438_assignment2.data.Track
import com.example.cse438.cse438_assignment2.data.TrackPayload

class TrackViewModel(application: Application): AndroidViewModel(application){
    public var trackList: MutableLiveData<TrackPayload> = MutableLiveData()
    public var track: MutableLiveData<Track> = MutableLiveData()
    public var tracksRepository: TracksRepository =
        TracksRepository()

    fun getChartTracks(){
        tracksRepository.getChartTracks(trackList)
    }
    fun getSearchTracks(input: String){
        tracksRepository.getSearchTracks(trackList, input)
    }
    fun getTrack(id: String){
        tracksRepository.getTrack(track, id)
    }

}