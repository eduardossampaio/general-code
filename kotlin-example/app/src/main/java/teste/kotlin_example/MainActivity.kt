package teste.kotlin_example

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

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
    }
}
