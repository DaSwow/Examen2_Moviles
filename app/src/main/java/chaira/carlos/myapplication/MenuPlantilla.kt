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
    var menu = ArrayList<Producto>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_plantilla)

        var menuOption:  String? = intent.getStringExtra("type")
        agregarProductos(menuOption)
        var listview: ListView =findViewById(R.id.listview) as ListView
        var adaptador: AdaptadorProductos=AdaptadorProductos(this, menu)
        listview.adapter=adaptador
    }
//    falta agregar imagenes img.setImageResource(R.drawable.nombreImagen)
//    falta agregar imagenes individuales R.drawable.imagen en .imagen va el nombre de la imagen
    fun agregarProductos(option:String?){
        var img: ImageView =findViewById(R.id.imgMenu) as ImageView
        when(option){
            "tacos" ->{
                img.setImageResource(R.drawable.tacos)
                menu.add(Producto("Taco Tradicional", R.drawable.tacos,"Traditional Taco", 2.35 ))
                menu.add(Producto("Taco de pescado", R.drawable.tacopescado,"Fish taco", 2.35))
            }
            "antojitos" ->{
                img.setImageResource(R.drawable.nombreImagen)
                menu.add(Producto("Quesadillas", R.drawable.imagen, "Rellenas con su carne favorita, servidas con ensalada. Filled with your choice of meat, served with salad.", 4.75))
                menu.add(Producto("Huaraches", R.drawable.huaraches, "Tortilla gruesa con frijoles, tu carne favorita, lechuga, queso fresco y crema. Big Thick tortilla with beans, your choice of meat, fresh cheese, and sour cream",9.87))
                menu.add(Producto("Gringas",R.drawable.gringas,"Tortilla de harina con queso, carne al pastor y piña Flour tortilla with cheese marinated pork and pineapple",6.47))
                menu.add(Producto("Sincronizadas",R.drawable.sincronizadas,"Tortilla de harina rellena con queso y jamon. Se sirve con lechuga, crema y guacamole Sandwich of Two four tortillas filled with ham and cheese. Served with lettuce, sour cream, and guacamole.",6.99))
                menu.add(Producto("Sopes",R.drawable.sopes,"Tortilla gruesa cubierta de frijoles, tu carne favorita, lechuga, queso fresco y crema Fried thick tortilla with beans, your choice of meat, lettuce, fresh cheese, sour cream and tomatoes",3.39))
                menu.add(Producto("Tostadas",R.drawable.tostadas,"Tortilla frita con frijoles, tu carne favorita, lechuga, queso fresco, crema y jitomate Fried tortilla with beans, your choice of meat, lettuce, fresh cheese, sour cream and tomatoes",3.55))
            }
            "especialidades" ->{
                img.setImageResource(R.drawable.nombreImagen)
                menu.add(Producto("Mojarra Frita - Fried Fish",R.drawable.mojarrafrita,"Tilapia frita servida con lechiga, cebolla, jitomate, aguacate y tortillas. Agregue arroz y frijoles por $1.50 adicinales Fried tilapia served with lettuce, onions, tomatoes, avocado and tortillas. Add rice and beans for $1.50 extra",14.49))
                menu.add(Producto("Tostadas de Ceviche",R.drawable.tostadaceviche,"Tilapia, camarones y pico de gallo servido en una crujiente tostada Tilapia, Shrimp and pico de gallo, served on a crispy shell",2.99))
                menu.add(Producto("Fajita Burrito",R.drawable.fajitaburrito,"Gran burrito relleno de tu carne favorita, cebolla, chile, arroz, frijoles y jitomate. Servido con lechuga y guacamole Large burrito filled with your choice of meat, onions, chile, peppers, rice, beans and tomatoes. Served with lettuce guacamole and sour cream.",11.79))
                menu.add(Producto("Fajita Quesadilla",R.drawable.fajitaquesadilla,"Quesadilla extra grande, rellena con tu carne favorita, cebolla asada, chile banana y jitomate. Servida con arroz, frijoles y ensalada Extra large quesadilla with your choice of meat, cooked with grilled onions, banana peppers and tomatoes. Served with rice beans and salad.",12.49))
                menu.add(Producto("Botana de Camarones",R.drawable.imagen,"",17.99))
                menu.add(Producto("Coctel Camaron",R.drawable.imagen,"",14.50))
            }

            "caldos" ->{
                img.setImageResource(R.drawable.nombreImagen)
                menu.add(Producto("Larger",R.drawable.caldolarger,"",10.99))
                menu.add(Producto("Camaron",R.drawable.caldocamaron,"",11.99))
            }

            "combinations" ->{
                img.setImageResource(R.drawable.nombreImagen)
                menu.add(Producto("Traditional Taco Combo",R.drawable.imagen,"Tortilla de Maiz, tu carne favorita, servido con arroz y frijoles Corn tortilla taco, your choice of meat, served with rice and beans",6.99))
                menu.add(Producto("Mexican Burritos",R.drawable.imagen,"Your choice of meat on a big burrito made of flour tortilla with rice, beans, lettuce, grilled onions, pico de gallo, guacamole and sour cream.",10.99))
                menu.add(Producto("Los Portales Burrito",R.drawable.imagen,"A flour tortilla wrapped around grilled cactus, steak, pastor, (Seasoned Pork) grilled onions, rice and beans. Served a side of lettuce salad, tomatoes, sour cream and guacamole.",11.79))
                menu.add(Producto("Cinco",R.drawable.imagen,"One hard sell taco with your choice of meat, lettuce and cheese. One burrito with your choice of meat, pico de gallo, sour cream, guacamole and beans. Served with rice and beans.",7.67))
                menu.add(Producto("Dos Amigos",R.drawable.imagen,"Two hard shell tacos with your choice of meat topped with lettuce and shredded cheese. served with a side of rice and beans",8.25))
                menu.add(Producto("Burrito Pepe",R.drawable.imagen,"A flour tortilla wrapped around your choice of meat with beans, lettuce, sour cream, guacamole and pico de gallo. served with a side of rice.",6.89))
            }

            "tortas" ->{
                img.setImageResource(R.drawable.nombreImagen)
                menu.add(Producto("Torta Regular",imagen,"All tortas come with lettuce, onions, tomatoes, avocado do, sour cream, mayo, jalapeno pepper and your choice of meat. ",10.95))
                menu.add(Producto("Torta -Milanesa de Res o Pollo",imagen,"Breaded Steak or Chicken",11.99))
                menu.add(Producto("Torta Cubana",imagen,"Chorizo, asada, jamon, pastor y queso Mexican sausage, steak, marinated pork, ham, and cheese",12.35))
                menu.add(Producto("Torta Mixta",imagen,"Chorizo, asada y pastor Mexican sausage, steak and marinated pork",11.99))
                menu.add(Producto("Small Mexican Torta",imagen,"Bolillo bread sandwich with your choice of filling. Topped with Lettuce, tomatoes, onions, and avocado.",6.89))
            }

            "sopas" ->{
                img.setImageResource(R.drawable.nombreImagen)
                menu.add(Producto("Pozole",R.drawable.imagen,"Weekends only",5.99))
                menu.add(Producto("Menudo",R.drawable.imagen,"Wednesday to Sunday",5.99))
                menu.add(Producto("Caldo de Res",R.drawable.imagen,"",5.99))
                menu.add(Producto("Caldo de Camaron",R.drawable.imagen,"Shrimp soup",10.69))
                menu.add(Producto("Sopa de Mariscos",R.drawable.imagen,"Seafood soup",15.75))
                menu.add(Producto("Coctel de Camaron",R.drawable.imagen,"Shrimp cocktail",13.50))
            }

            "sideOrders" ->{
                img.setImageResource(R.drawable.nombreImagen)
                menu.add(Producto("Side of Guacamole",R.drawable.imagen,"",3.75))
                menu.add(Producto("Side Of Rice",R.drawable.imagen,"",1.99))
                menu.add(Producto("Side Of Beans",R.drawable.imagen,"",1.99))
                menu.add(Producto("Chips And Salsa",R.drawable.imagen,"",2.25))
                menu.add(Producto("Flour Tacos",R.drawable.imagen,"",2.99)
            }

            "drinks" ->{
                img.setImageResource(R.drawable.nombreImagen)
                menu.add(Producto("Sodas 20oz.",R.drawable.imagen,"",2.75))
                menu.add(Producto("Jarritos",R.drawable.imagen,"",2.35))
                menu.add(Producto("Aguas Frescas",R.drawable.imagen,"",2.75))
                menu.add(Producto("Domestic Beer",R.drawable.imagen,"",3.55))
                menu.add(Producto("Mexican Beer",R.drawable.imagen,"",3.99))
                menu.add(Producto("Micheladas",R.drawable.imagen,"",6.75))
                menu.add(Producto("Caguama",R.drawable.imagen,"",7.99))
                menu.add(Producto("Caguama Michelada",R.drawable.imagen,"",10.99))
                menu.add(Producto("Cubetazos",R.drawable.imagen,"",19.99))
                menu.add(Producto("Lata Beer",R.drawable.imagen,"",2.99))
                menu.add(Producto("Charolazo",R.drawable.imagen,"",15.75))
                menu.add(Producto("Carolazo con camarones",R.drawable.imagen,"",21.99))
                menu.add(Producto("La mamalona",R.drawable.imagen,"(michelada 2 Cervesas)",12.99))
                menu.add(Producto("La mamalona con camarones",R.drawable.imagen,"",14.99))
                menu.add(Producto("Cubetazo (6 cervesas)",R.drawable.imagen,"",21.99))
            }
        }

    }
    private class AdaptadorProductos: BaseAdapter {
        var productos=ArrayList<Producto>()
        var contexto: Context?=null

        constructor(contexto: Context, producto: ArrayList<Producto>){
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