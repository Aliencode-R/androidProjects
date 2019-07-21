package com.example.github_api_json

data class ApiResult(val total_count : Int, val incomplete_results: Boolean, val items : ArrayList<GithubUser>)