package rakib.hasan.dynamicviews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import rakib.hasan.dynamicviews.adapters.MainRvAdapter
import rakib.hasan.dynamicviews.databinding.ActivityMainBinding
import rakib.hasan.dynamicviews.utils.Const

class MainActivity : AppCompatActivity() {
    companion object{
        private val className = MainActivity::class.java.simpleName
    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.v(className, Const.getList().toString())

        val mainRvAdapter = MainRvAdapter(applicationContext, Const.getList())
        val lManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.mainRv.apply {
            layoutManager = lManager
            adapter = mainRvAdapter
        }
    }

}