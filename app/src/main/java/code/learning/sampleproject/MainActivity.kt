package code.learning.sampleproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import code.learning.sampleproject.base.BaseActivity
import code.learning.sampleproject.base.BaseViewModel

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun getViewModel(): BaseViewModel? {
        return null
    }
}