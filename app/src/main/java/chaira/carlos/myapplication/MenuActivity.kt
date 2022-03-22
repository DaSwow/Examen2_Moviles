package chaira.carlos.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MenuActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        var btnTacos: Button = findViewById(R.id.tacosbtn) as Button
        var btnAntojitos: Button = findViewById(R.id.antojitosbtn) as Button
        var btnEspecialidades: Button = findViewById(R.id.especialidadesbtn) as Button
        var btnCaldos: Button = findViewById(R.id.caldosbtn) as Button
        var btnCombinations: Button = findViewById(R.id.combinationsbtn) as Button
        var btnTortas: Button = findViewById(R.id.tortasbtn) as Button
        var btnSopas: Button = findViewById(R.id.sopasbtn) as Button
        var btnSideOrders: Button = findViewById(R.id.sideOrdersbtn) as Button
        var btnDrinks: Button = findViewById(R.id.drinksbtn) as Button



        val button: Button = findViewById(R.id.btn_carrito)
        button.setOnClickListener{
            var intent: Intent = Intent (this, CarritoActivity::class.java)
            startActivity(intent)
        }

        btnTacos.setOnClickListener{
            var intent: Intent = Intent(this, MenuPlantilla::class.java)
            intent.putExtra("type", "tacos")
            startActivity(intent)
        }
        btnAntojitos.setOnClickListener{
            var intent: Intent = Intent(this, MenuPlantilla::class.java)
            intent.putExtra("type", "antojitos")
            startActivity(intent)
        }
        btnEspecialidades.setOnClickListener{
            var intent: Intent = Intent(this, MenuPlantilla::class.java)
            intent.putExtra("type", "especialidades")
            startActivity(intent)
        }
        btnCaldos.setOnClickListener{
            var intent: Intent = Intent(this, MenuPlantilla::class.java)
            intent.putExtra("type", "caldos")
            startActivity(intent)
        }
        btnCombinations.setOnClickListener{
            var intent: Intent = Intent(this, MenuPlantilla::class.java)
            intent.putExtra("type", "combinations")
            startActivity(intent)
        }
        btnTortas.setOnClickListener{
            var intent: Intent = Intent(this, MenuPlantilla::class.java)
            intent.putExtra("type", "tortas")
            startActivity(intent)
        }
        btnSopas.setOnClickListener{
            var intent: Intent = Intent(this, MenuPlantilla::class.java)
            intent.putExtra("type", "sopas")
            startActivity(intent)
        }
        btnSideOrders.setOnClickListener{
            var intent: Intent = Intent(this, MenuPlantilla::class.java)
            intent.putExtra("type", "sideOrders")
            startActivity(intent)
        }
        btnDrinks.setOnClickListener{
            var intent: Intent = Intent(this, MenuPlantilla::class.java)
            intent.putExtra("type", "drinks")
            startActivity(intent)
        }
    }
}