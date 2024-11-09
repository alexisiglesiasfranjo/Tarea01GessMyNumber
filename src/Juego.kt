import jdk.incubator.vector.VectorOperators.Test
import java.util.function.Predicate

class Juego : Predicate<Char>{

    var numeroRandom = crearNumero().toString()
    var intentos = 0
    var ganado = false

    fun crearNumero() : Int{
        var numero = mutableListOf(1,2,3,4,5)
        numero.shuffle()
        return numero.take(4).joinToString("").toInt()
    }



    fun incrementarIntentos(){
        this.intentos++
    }


    fun testRojo(t:String) : Int{
        return t.count{ test(it) }
    }

    fun testVerde(t:String) : Int{
        var correctas = 0
        for (i in t.indices){
            if (t[i]==numeroRandom[i])
                correctas++
        }
        return correctas
    }

    override fun test(t: Char): Boolean {
        if(t !in numeroRandom){
            return false
        }else {
            return true
        }
    }
}