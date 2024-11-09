import java.util.function.Predicate

class NumeroRandom{

    var numeroRandom = crearNumero()

    fun crearNumero() : Int{
        var numero = mutableListOf(1,2,3,4,5)
        numero.shuffle()
        return numero.take(4).joinToString("").toInt()
    }

    override fun toString(): String {
        return numeroRandom.toString()
    }

}