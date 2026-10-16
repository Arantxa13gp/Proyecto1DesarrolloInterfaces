package org.example.project.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.example.project.models.GaleriaArte
import org.example.project.viewModels.GaleriaArteVM

@Composable
fun GaleriaArteScreen(
    viewModel: GaleriaArteVM
) {
    val uiState by viewModel.uiState.collectAsState()

    var obraSeleccionada by remember {
        mutableStateOf<GaleriaArte?>(null)
    }

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            Text(
                text = "Galería de arte",
                style = MaterialTheme.typography.headlineMedium
            )

            if (obraSeleccionada == null) {

                Text(
                    text = "Selecciona una obra para ver sus detalles",
                    style = MaterialTheme.typography.bodyLarge
                )

                uiState.items.forEach { obra ->

                    Button(
                        onClick = {
                            obraSeleccionada = obra
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(text = obra.titulo)
                    }
                }

            } else {

                val obra = obraSeleccionada!!

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 6.dp
                    )
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {

                        Text(
                            text = obra.titulo,
                            style = MaterialTheme.typography.headlineSmall
                        )

                        Text(
                            text = "ID: ${obra.id}"
                        )

                        Text(
                            text = "Artista: ${obra.artista}"
                        )

                        Text(
                            text = "Año de creación: ${obra.añoCreacion}"
                        )

                        Text(
                            text = "Descripción:"
                        )

                        Text(
                            text = obra.descripcion,
                            style = MaterialTheme.typography.bodyLarge
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Button(
                            onClick = {
                                obraSeleccionada = null
                            },
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(text = "Cerrar ficha")
                        }
                    }
                }
            }
        }
    }
}