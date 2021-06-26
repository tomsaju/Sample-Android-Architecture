package code.learning.sampleproject.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

abstract class BaseViewModel:ViewModel() {

    var progressBarLiveData:MutableLiveData<Boolean> = MutableLiveData()

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        onError("Exception handled: ${throwable.localizedMessage}")
    }

    fun getCoroutineContext(): CoroutineContext {
        return Dispatchers.IO+exceptionHandler
    }

    fun startLoader(){
        progressBarLiveData.postValue(true)
    }

    fun stopLoader(){
        progressBarLiveData.postValue(false)
    }

    abstract fun onError(error:String)
}