package me.dio.appbeber

class Calcular {

    private val jovem = 40.0
    private val adulto = 35.0
    private val idoso = 30.0
    private val muito_idoso = 25.0


    private var resultado = 0.0
    private var resultado_total = 0.0


    fun caulcularML(peso:Double, idade:Int){

        if (idade <= 17){
            resultado = peso * jovem
            resultado_total = resultado

        }else if(idade <=55){

            resultado = peso * adulto
            resultado_total = resultado


        }else if (idade <=65){
            resultado = peso * idoso
            resultado_total = resultado

        }else{
            resultado = peso * muito_idoso
            resultado_total = resultado
        }


    }

    fun res(): Double{
        return resultado_total
    }
}