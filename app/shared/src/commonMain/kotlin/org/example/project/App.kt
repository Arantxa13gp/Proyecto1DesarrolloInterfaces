package org.example.project

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import org.example.project.viewModels.GaleriaArteVM
import org.example.project.views.BaseScreen

@Composable
fun App() {
    MaterialTheme {
        val viewModel: GaleriaArteVM = viewModel { GaleriaArteVM() }
        BaseScreen(viewModel = viewModel)
    }
}