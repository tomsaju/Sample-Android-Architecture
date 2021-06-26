package code.learning.sampleproject.features.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import code.learning.sampleproject.R
import code.learning.sampleproject.base.BaseActivity
import code.learning.sampleproject.base.BaseViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : BaseActivity() {
    private val viewModel:HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        observeMoviesList()
        viewModel.getAllMovies()

    }

    private fun observeMoviesList() {
        viewModel.movieList.observe(this, Observer {
            movieList->
            //set adapter and populate list
        })
    }

    override fun getViewModel(): BaseViewModel? {
        return viewModel
    }
}