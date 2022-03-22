package chaira.carlos.myapplication

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import androidx.core.view.size
import chaira.carlos.myapplication.MainActivity.Companion.carrito

class CarritoActivity : AppCompatActivity() {
    var menu = ArrayList<Producto>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carrito)
        agregarProductos()
        var listview: ListView = findViewById<ListView>(R.id.listview)
        var total: TextView = findViewById<TextView>(R.id.totalNum)
        var adaptador: AdaptadorProductos=AdaptadorProductos(this, menu, total)

        listview.adapter=adaptador

        var cantidadTotal=0.0
        var contador=0
        while (true){
            if(carrito!=null && carrito.size>0) {

                cantidadTotal +=   String.format("%.2f", (carrito.get(contador) as Producto).price * (carrito.get(contador) as Producto).cantidad).toDouble()
                contador++
                if (contador == carrito.size){
                    break}
            }else{
                break
            }
        }
        total.text = "$cantidadTotal"
    }

    fun agregarProductos(){
        menu = carrito
    }



    class AdaptadorProductos: BaseAdapter {
        var productos=ArrayList<Producto>()
        var contexto: Context?=null
        var total: TextView?=null

        constructor(contexto: Context, producto: ArrayList<Producto>, total: TextView){
            this.productos=producto
            this.contexto=contexto
            this.total=total
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

            var cantidad= vista.findViewById(R.id.cantidad_producto) as TextView
            var numeroCantidad = prod.cantidad
            cantidad.setText("${numeroCantidad}")



            (vista.findViewById(R.id.btn_mas) as Button).setOnClickListener { view ->
                if(carrito.contains(prod)) {
                    carrito.remove(prod)
                }

                numeroCantidad += 1
                cantidad.setText("$numeroCantidad")
                prod.cantidad = numeroCantidad

                var precioActual = numeroCantidad * prod.price
                precioActual =  String.format("%.2f", precioActual).toDouble()
                precio.setText("$precioActual")
                carrito.add(prod)

                var precioTotal : Double = java.lang.Double.parseDouble(total?.text.toString());
                precioTotal += prod.price
                total?.text = String.format("%.2f", precioTotal)
            }

            (vista.findViewById(R.id.btn_menos) as Button) .setOnClickListener { view ->


                if (numeroCantidad != 0.0){
                    numeroCantidad -= 1
                    cantidad.setText("${numeroCantidad}")

                    var precioActual = numeroCantidad * prod.price
                    precioActual =  String.format("%.2f", precioActual).toDouble()
                    precio.setText("${precioActual}")

                    var precioTotal : Double = java.lang.Double.parseDouble(total?.text.toString());
                    precioTotal -=  prod.price
                    total?.text =  String.format("%.2f", precioTotal)

                    if(numeroCantidad==0.0){
                        carrito.remove(prod)
                    }
                }

            }
            return vista
        }
    }




}

