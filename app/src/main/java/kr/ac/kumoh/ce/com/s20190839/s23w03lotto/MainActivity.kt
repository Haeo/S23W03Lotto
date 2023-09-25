package kr.ac.kumoh.ce.com.s20190839.s23w03lotto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import kr.ac.kumoh.ce.com.s20190839.s23w03lotto.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var main: ActivityMainBinding
    private lateinit var model: LottoViewModel
    private lateinit var txtNum: Array<TextView?>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("Lifecycle!!!", "onCreate()")

        //setContentView(R.layout.activity_main)
        main = ActivityMainBinding.inflate(layoutInflater)
        setContentView(main.root)

        txtNum = arrayOf(main.num1, main.num2, main.num3,
            main.num4, main.num5, main.num6)

        model = ViewModelProvider(this)[LottoViewModel::class.java]
        txtNum.forEachIndexed{index, textView ->
            textView?.text = model.numbers[index].toString()
        }

        main.btnGenerate.setOnClickListener {
            model.generate()
            txtNum.forEachIndexed { index, textView ->
                textView?.text = model.numbers[index].toString()
            }
//            main.num1.text = Random.nextInt(1, 46).toString()
//            main.num2.text = Random.nextInt(1, 46).toString()
//            main.num3.text = Random.nextInt(1, 46).toString()
//            main.num4.text = Random.nextInt(1, 46).toString()
//            main.num5.text = Random.nextInt(1, 46).toString()
//            main.num6.text = Random.nextInt(1, 46).toString()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i("Lifecycle!!!", "onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.i("Lifecycle!!!", "onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.i("Lifecycle!!!", "onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.i("Lifecycle!!!", "onStop()")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("Lifecycle!!!", "onRestart()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("Lifecycle!!!", "onDestroy()")
    }
}