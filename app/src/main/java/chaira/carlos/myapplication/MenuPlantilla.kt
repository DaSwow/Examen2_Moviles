package chaira.carlos.myapplication

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView

class MenuPlantilla : AppCompatActivity() {
    var menu = ArrayList<Product>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_plantilla)

        var menuOption:  String? = intent.getStringExtra("type")
        agregarProductos(menuOption)
        var listview: ListView =findViewById(R.id.listview) as ListView
        var adaptador: AdaptadorProductos=AdaptadorProductos(this, menu)
        listview.adapter=adaptador
    }
//    termianar de agregar todos los platillos e imagenes equizde
    fun agregarProductos(option:String?){
        var img: ImageView =findViewById(R.id.imgMenu) as ImageView
        when(option){
            "tacos" ->{
                img.setImageResource(R.drawable.tacos)
                menu.add(Producto("Taco Tradicional", R.drawable.tacos,"Traditional Taco", 2.35 ))
                menu.add(Producto("Taco de pescado",imagen,"Fish taco", 2.35))
            }
            "antojitos" ->{
                //imagen
                menu.add(Producto("Quesadillas", imagen de quesadilla, "Rellenas con su carne favorita, servidas con ensalada. Filled with your choice of meat, served with salad.", 4.75))
                menu.add(Producto("Huaraches", imagen, "Tortilla gruesa con frijoles, tu carne favorita, lechuga, queso fresco y crema. Big Thick tortilla with beans, your choice of meat, fresh cheese, and sour cream",9.87))
                menu.add(Producto("Gringas",imagen,"Tortilla de harina con queso, carne al pastor y piña Flour tortilla with cheese marinated pork and pineapple",6.47))
                menu.add(Producto("Sincronizadas",imagen,"Tortilla de harina rellena con queso y jamon. Se sirve con lechuga, crema y guacamole Sandwich of Two four tortillas filled with ham and cheese. Served with lettuce, sour cream, and guacamole.",6.99))
                menu.add(Producto("Sopes",imagen,"Tortilla gruesa cubierta de frijoles, tu carne favorita, lechuga, queso fresco y crema Fried thick tortilla with beans, your choice of meat, lettuce, fresh cheese, sour cream and tomatoes",3.39))
                menu.add(Producto("Tostadas",imagen,"Tortilla frita con frijoles, tu carne favorita, lechuga, queso fresco, crema y jitomate Fried tortilla with beans, your choice of meat, lettuce, fresh cheese, sour cream and tomatoes",3.55))
            }
            "especialidades" ->{
                menu.add(Producto("Mojarra Frita - Fried Fish",imagen,"Tilapia frita servida con lechiga, cebolla, jitomate, aguacate y tortillas. Agregue arroz y frijoles por $1.50 adicinales Fried tilapia served with lettuce, onions, tomatoes, avocado and tortillas. Add rice and beans for $1.50 extra",14.49))


            }
            "caldos" ->{


            }
            "combinations" ->{


            }
            "tortas" ->{


            }
            "sopas" ->{


            }
            "sideOrders" ->{


            }
            "drinks" ->{


            }
        }

    }
    private class AdaptadorProductos: BaseAdapter {
        var productos=ArrayList<Product>()
        var contexto: Context?=null

        constructor(contexto: Context, producto: ArrayList<Product>){
            this.productos=producto
            this.contexto=contexto
        }

        override fun getCount(): Int {
            return productos.size
        }

        override fun getItem(p0: Int): Any {
            return productos[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            var prod=productos[p0]
            var inflador= LayoutInflater.from(contexto)
            var vista = inflador.inflate(R.layout.productos, null)

            var image=vista.findViewById(R.id.producto_img) as ImageView
            var nombre = vista.findViewById(R.id.nombre_producto) as TextView
            var desc = vista.findViewById(R.id.descripcion_producto) as TextView
            var precio = vista.findViewById(R.id.precio_producto) as TextView

            image.setImageResource(prod.image)
            nombre.setText(prod.name)
            desc.setText(prod.description)
            precio.setText("$${prod.price}")
            return vista
        }
    }
}