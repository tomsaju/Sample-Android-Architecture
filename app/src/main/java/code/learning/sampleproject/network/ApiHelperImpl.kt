package code.learning.sampleproject.network

import code.learning.sampleproject.model.Movie
import code.learning.sampleproject.model.User
import retrofit2.Response
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(private val apiService: ApiService):ApiHelper {
    override suspend fun getMovies(): Response<List<Movie>>  = apiService.getMovies()
}