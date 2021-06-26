package code.learning.sampleproject.base


import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.lifecycle.Observer
import code.learning.sampleproject.R
import dmax.dialog.SpotsDialog

abstract class BaseActivity : AppCompatActivity() {

    lateinit var mProgressDialog: AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        createProgressBar()
        observeProgressBarEvents()
    }

    private fun observeProgressBarEvents() {
        getViewModel()?.progressBarLiveData?.observe(this, Observer {
            if(it){
                showProgressBar()
            }else{
                hideProgressBar()
            }
        })
    }

    private fun createProgressBar() {
        mProgressDialog = SpotsDialog.Builder().setContext(this).build()
    }

    fun showProgressBar(){
        mProgressDialog.show()
    }

    fun hideProgressBar(){
        mProgressDialog.hide()
    }

    abstract fun getViewModel():BaseViewModel?

}