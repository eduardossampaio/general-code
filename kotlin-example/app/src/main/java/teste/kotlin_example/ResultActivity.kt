package teste.kotlin_example

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val extra_name = this.intent.extras.getString("EXTRA_NOME")
        val extra_algo = this.intent.extras.getString("EXTRA_ALGO")

        name_result.text = extra_name
        message_result.text = extra_algo
    }
}
