package org.example.project.viewModels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import org.example.project.models.GaleriaArte
import org.example.project.states.GaleriaArteState

class GaleriaArteVM : ViewModel() {
    private val _uiState = MutableStateFlow(GaleriaArteState())
    val uiState: StateFlow<GaleriaArteState> = _uiState

    init {
        loadInitialData()
    }

    private fun loadInitialData() {
        val artPictures = listOf(
            GaleriaArte(1, "La caprichosa", "Leonardo", 1989, "Esta obra tiene un origen indescriptible"),
            GaleriaArte(2, "La Sosa", "Leonardo", 1989, "Esta obra tiene un origen indescriptible")
        )

        val booleana = MutableList(artPictures.size) { false }

        _uiState.update { currentState ->
            currentState.copy(artPictures = artPictures, booleana = booleana)
        }
    }

    fun cambiaBoolean(posicion: Int) {
        println("Posicion: $posicion")

        val booleana = uiState.value.booleana
        println(booleana)
        booleana[posicion] = !booleana[posicion]
        println(booleana)
        _uiState.update { currentState ->
            println(currentState.copy(booleana = booleana))
            currentState.copy(artPictures = uiState.value.artPictures, booleana = booleana, posicion=posicion)
        }
    }

}