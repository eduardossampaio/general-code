package teste.kotlin_example

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import java.net.URL

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_main)

        sendButton.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java).apply {
                putExtra("EXTRA_NOME",nameText.text.toString())
                putExtra("EXTRA_ALGO",somethingText.text.toString())
            }
            startActivity(intent)
        };
        retrieveFromServer()
    }

    private fun retrieveFromServer(){
        doAsync {
            var url = "http://json.org/example.html";
            Request(url).run();
        }
    }
    class Request(val url: String) {

        fun run() {
            val forecastJsonStr = URL(url).readText()
            Log.d(javaClass.simpleName, forecastJsonStr)
        }

    }
}
