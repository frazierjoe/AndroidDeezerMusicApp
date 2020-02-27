package com.example.cse438.cse438_assignment2.data

import android.media.Image

//import android.media.Image

data class DisplayObject(
    var image: String,
    var mainText: String,
    var subText: String,
    var objectType: String,
    var artist: Artist?,
    var track: Track?,
    var album: Album?,
    var id: String?
)