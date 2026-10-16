package org.example.project.models
data class GaleriaArte(
    var id: Int,
    var titulo: String,
    var artista: String,
    var añoCreacion: Int,
    var descripcion: String

){
    fun categoriaObra():String{
        if (añoCreacion < 1900){
            return "la obra es historica"
        }else
            return "La obra es antigua"
    }
}