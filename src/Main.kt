//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {

    var salir = false
    var opcion : Int?
    val ROJO = "\u001B[41m"
    val VERDE = "\u001B[42m"
    val RESET = "\u001B[0m"
    var intentosUltimaPartida = 0
    var resultUltimaPartida = false

    do{
        println("--Hola! Selecciona una opción--")
        println("1. Jugar \n 2.Ver último intento \n 3.Salir \n")
        print("Opción: ")

        opcion = readln().toInt()

        if (opcion == 1){
            println("Bienvenido. Tendras que escribir un número de 4 dígitos." +
                    "En el semáforo se indicará el número de dígitos correctos: ")
            println("${ROJO}En rojo el número de dígitos correctos en la posición incorrecta ${RESET}")
            println("${VERDE}En verde el número de dígitos correctos en la posición correcta ${RESET}")
            println("Escoge la dificultad: ")
            println(" 1. Fácil \n 2.Medio \n 3.Difícil \n")
            var dificultad = readln().toInt()


            var juego = Juego(dificultad)
            when{
                dificultad == 1 -> println("Los dígitos pueden ser números del 1 al 4 sin repetirse")
                dificultad == 2 -> println("Los dígitos pueden ser números del 1 al 5 sin repetirse")
                dificultad == 3 -> println("Los dígitos pueden ser números del 1 al 6 sin repetirse")
            }

            println("Tienes un total de 10 oportunidades. Adelante: \n")

            for(i in 1..10){
                juego.incrementarIntentos()

                var usuario = readln()
                var correctasV = juego.testVerde(usuario)
                var correctasR = (juego.testRojo(usuario))-correctasV

                print("${ROJO}$correctasR ${VERDE}$correctasV${RESET} \n")
                if (correctasV==4){
                    juego.ganado = true
                    println("HAS GANADO! =D")
                    break
                }else if(i==10 && correctasV!=4){
                    println("Has perdido ='(")
                    println("El número correcto era ${juego.numeroRandom}")
                }
            }
            intentosUltimaPartida = juego.intentos
            resultUltimaPartida = juego.ganado

        }else if (opcion == 2){
            if (resultUltimaPartida){
                println("${VERDE}Los intentos de la ultima partida " +
                        "han sido $intentosUltimaPartida y has ganado ${RESET}")
            }else{
                println("${ROJO}Los intentos de la ultima partida " +
                        "han sido $intentosUltimaPartida y has perdido${RESET}")
            }

        }else if(opcion == 3){
            println("Adiós.")
            salir = true
            continue
        }else{
            println("Escoge una opción entre 1, 2 o 3.")
        }


    }while (!salir)
}
