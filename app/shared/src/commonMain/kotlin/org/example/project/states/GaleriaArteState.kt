package org.example.project.states

import org.example.project.models.GaleriaArte


data class GaleriaArteState(
    val items: List<GaleriaArte> = emptyList(),
    val selectedItem: GaleriaArte? = null,
    val artPictures: List<GaleriaArte>,
    val booleana : MutableList<Boolean> = mutableListOf(),
    val posicion : Int = 3
)

