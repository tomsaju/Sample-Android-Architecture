package code.learning.sampleproject.network

import code.learning.sampleproject.model.Movie
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("movielist.json")
    suspend fun getMovies(): Response<List<Movie>>
}