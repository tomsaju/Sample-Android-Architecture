package code.learning.sampleproject.network

import code.learning.sampleproject.model.Movie
import retrofit2.Response

interface ApiHelper {
    suspend fun getMovies():Response<List<Movie>>
}