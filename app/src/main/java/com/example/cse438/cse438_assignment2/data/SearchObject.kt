package com.example.cse438.cse438_assignment2.data



data class SearchObject(
    val id: String,
    val type: String
)

data class SearchPayload(
    val data: List<SearchObject>,
    val total: Int,
    val next: String
)