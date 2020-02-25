package com.example.cse438.cse438_assignment2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cse438.cse438_assignment2.fragments.GridFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //Start the grid fragment
        val fragment = GridFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.commit()
    }
}
