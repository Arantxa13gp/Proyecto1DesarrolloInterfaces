package org.example.project.viewModels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import org.example.project.models.GaleriaArteModel
import org.example.project.states.GaleriaArteState

class GaleriaArteVM : ViewModel() {

    private val _uiState = MutableStateFlow(GaleriaArteState())
    val uiState: StateFlow<GaleriaArteState> = _uiState

    init {
        loadInitialData()
    }

    private fun loadInitialData() {
        val obras = listOf(
            GaleriaArteModel(
                id = 1,
                titulo = "La noche estrellada",
                artista = "Vincent van Gogh",
                añoCreacion = 1889,
                descripcion = "Pintura al óleo que representa un paisaje nocturno con un cielo lleno de estrellas y una pequeña localidad."
            ),
            GaleriaArteModel(
                id = 2,
                titulo = "La Gioconda",
                artista = "Leonardo da Vinci",
                añoCreacion = 1503,
                descripcion = "Retrato de una mujer con una expresión enigmática, conocido por su técnica pictórica y su famosa sonrisa."
            )
        )

        val booleana = MutableList(obras.size) { false }

        _uiState.update { currentState ->
            currentState.copy(
                items = obras,
                booleana = booleana
            )
        }
    }

    fun cambiaBoolean(posicion: Int) {
        println("Posicion: $posicion")

        val booleana = uiState.value.booleana.toMutableList()

        if (posicion in booleana.indices) {
            booleana[posicion] = !booleana[posicion]

            println(booleana)

            _uiState.update { currentState ->
                currentState.copy(
                    booleana = booleana,
                    posicion = posicion
                )
            }
        }
    }
}