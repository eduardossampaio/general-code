package teste.kotlin_example

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var nameEditText = findViewById(R.id.nameText) as TextView
        var somethingEditText = findViewById(R.id.somethingText) as TextView
        var sendButton = findViewById(R.id.sendButton) as Button

        sendButton.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("EXTRA_NOME",nameEditText.text.toString())
            intent.putExtra("EXTRA_ALGO",somethingEditText.text.toString())
            startActivity(intent)
        };
    }
}
