package code.learning.sampleproject.repository

import code.learning.sampleproject.network.ApiHelper
import javax.inject.Inject

class HomeRepository @Inject constructor(private val apiHelper: ApiHelper) {
    suspend fun getMovies() = apiHelper.getMovies()
}