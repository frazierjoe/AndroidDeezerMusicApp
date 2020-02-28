package com.example.cse438.cse438_assignment2.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Playlist::class), version = 2, exportSchema = false)
public abstract class PlaylistRoomDatabase : RoomDatabase() {

    abstract fun playlistDao(): PlaylistDAO

    //singleton pattern
    companion object {

        @Volatile
        private var INSTANCE: PlaylistRoomDatabase? = null

        fun getDatabase(context: Context) : PlaylistRoomDatabase {
            val temp = INSTANCE
            if(temp != null) {
                return temp
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PlaylistRoomDatabase::class.java,
                    "playlist_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}