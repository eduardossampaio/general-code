package teste.kotlin_example

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val extra_name = this.intent.extras.getString("EXTRA_NOME")
        val extra_algo = this.intent.extras.getString("EXTRA_ALGO")

        var name = findViewById(R.id.name_result) as TextView;
        var message = findViewById(R.id.message_result) as TextView;

        name.setText(extra_name)
        message.setText(extra_algo)
    }
}
