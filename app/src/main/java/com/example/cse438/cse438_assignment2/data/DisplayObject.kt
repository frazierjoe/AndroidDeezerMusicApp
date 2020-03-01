package com.example.cse438.cse438_assignment2.data

import com.example.cse438.cse438_assignment2.db.Song


data class DisplayObject(
    var image: String,
    var mainText: String,
    var subText: String,
    var objectType: String,
    var artist: Artist?,
    var track: Track?,
    var album: Album?,
    var id: String?,
    var song: Song?
)