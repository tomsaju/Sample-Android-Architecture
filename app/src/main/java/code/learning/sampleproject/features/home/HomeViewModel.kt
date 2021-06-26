package code.learning.sampleproject.features.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import code.learning.sampleproject.base.BaseViewModel
import code.learning.sampleproject.model.Movie
import code.learning.sampleproject.repository.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: HomeRepository) : BaseViewModel() {

    val movieList = MutableLiveData<List<Movie>>()

    fun getAllMovies() {
        viewModelScope.launch(getCoroutineContext()) {
            startLoader()
            val moviesResponse = repository.getMovies()
            if (moviesResponse.isSuccessful) {
                movieList.postValue(moviesResponse.body())
            } else {
                onError(moviesResponse.message())
            }
            stopLoader()
        }
    }

    override fun onError(error: String) {
        //handle coroutine exceptions here
        stopLoader()
    }


}