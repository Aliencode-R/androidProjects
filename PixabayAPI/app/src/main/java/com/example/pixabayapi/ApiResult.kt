package com.example.pixabayapi

data class ApiResult(val totalHits : Int, val hits : ArrayList<PixabayUser>, val total: Int)
