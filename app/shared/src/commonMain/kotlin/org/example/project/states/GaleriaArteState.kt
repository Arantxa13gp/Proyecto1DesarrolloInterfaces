package org.example.project.states

import org.example.project.models.GaleriaArteModel

data class GaleriaArteState(
    val items: List<GaleriaArteModel> = emptyList(),
    val selectedItem: GaleriaArteModel? = null,
    val artPictures: List<GaleriaArteModel> = emptyList(),
    val booleana: MutableList<Boolean> = mutableListOf(),
    val posicion: Int = 3
)