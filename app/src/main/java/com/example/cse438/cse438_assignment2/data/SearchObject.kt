package com.example.cse438.cse438_assignment2.data

import com.squareup.moshi.Json

data class SearchObject(
    val id: String,
    val type: String
)

data class SearchPayload(
    val data: List<SearchObject>,
    val total: Int,
    val next: String
)