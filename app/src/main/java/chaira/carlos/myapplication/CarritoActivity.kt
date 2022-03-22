package chaira.carlos.myapplication

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import chaira.carlos.myapplication.MainActivity.Companion.carrito

class CarritoActivity : AppCompatActivity() {
    var menu = ArrayList<Producto>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carrito)
        agregarProductos()
        var listview: ListView = findViewById(R.id.listview) as ListView
        var adaptador: AdaptadorProductos=AdaptadorProductos(this, menu)
        listview.adapter=adaptador
    }

    fun agregarProductos(){
        menu = carrito
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

            var image= vista.findViewById(R.id.producto_img) as ImageView
            var nombre = vista.findViewById(R.id.nombre_producto) as TextView
            var desc = vista.findViewById(R.id.descripcion_producto) as TextView
            var precio = vista.findViewById(R.id.precio_producto) as TextView

            image.setImageResource(prod.image)
            nombre.setText(prod.name)
            desc.setText(prod.description)

            precio.setText("${(prod.cantidad*prod.price)}")

            (vista.findViewById(R.id.btn_mas) as Button).setOnClickListener { view ->
                if(carrito.contains(prod)) {
                    carrito.remove(prod)
                }

                var cantidad= vista.findViewById(R.id.cantidad_producto) as TextView
                var numeroCantidad = ((cantidad.text) as String).toDouble()
                numeroCantidad += 1
                cantidad.setText("${numeroCantidad}")
                prod.cantidad = numeroCantidad

                var precioActual = numeroCantidad * prod.price
                precioActual =  String.format("%.2f", precioActual).toDouble()
                precio.setText("${precioActual}")


                carrito.add(prod)

            }

            (vista.findViewById(R.id.btn_menos) as Button) .setOnClickListener { view ->
                var cantidad= vista.findViewById(R.id.cantidad_producto) as TextView
                var numeroCantidad = ((cantidad.text) as String).toDouble()

                if (numeroCantidad != 0.0){
                    numeroCantidad -= 1
                    cantidad.setText("${numeroCantidad}")

                    var precioActual = numeroCantidad * prod.price
                    precioActual =  String.format("%.2f", precioActual).toDouble()
                    precio.setText("${precioActual}")}

                if(numeroCantidad==0.0){
                    carrito.remove(prod)
                }
            }
            return vista
        }
    }


}