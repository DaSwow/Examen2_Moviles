package chaira.carlos.myapplication


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.btn_menu)
        button.setOnClickListener{
            var intent: Intent = Intent (this, MenuActivity::class.java)
            startActivity(intent)
        }

    }
}