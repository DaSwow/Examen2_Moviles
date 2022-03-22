package chaira.carlos.myapplication

data class Producto( var name: String,
                    var image: Int,
                    var description: String,
                    var price: Double,
                    var cantidad: Double = 0.0
                     )