package com.example.firebaseandroid.ui.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.firebaseandroid.navigasi.DestinasiNavigasi
import com.example.firebaseandroid.ui.viewmodel.PenyediaViewModel
import com.example.firebaseandroid.ui.viewmodel.UpdateMhsViewModel
import kotlinx.coroutines.launch


object DestinasiUpdate : DestinasiNavigasi {
    override val route = "update"
    const val NIM = "nim"
    val routesWithArg = "$route/{$NIM}"
    override val titleRes = "Update Mhs"
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UpdateView(
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: UpdateMhsViewModel = viewModel(factory = PenyediaViewModel.Factory)
) {
    val coroutineScope = rememberCoroutineScope()
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    // Collect the UI state from the ViewModel
    val uiState = viewModel.uiState.value

    Scaffold(
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBar(
                title = { Text("HOME") }
            )
        },
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {

//            InsertBodyMhs(
//                insertUiState = uiState,
//                onMahasiswaValueChange = { updatedValue ->
//                    viewModel.updateMhsState(updatedValue) // Update ViewModel state
//                },
//                onClick = {
//                    uiState.insertUiEvent?.let { insertUiEvent ->
//                        coroutineScope.launch {
//                            // Call ViewModel update method
//                            viewModel.updateMhs(
//                                nim = viewModel.nim, // Pass the NIM from ViewModel
//                                mahasiswa = insertUiEvent.toMhs() // Convert InsertUiEvent to Mahasiswa
//                            )
//                            navigateBack() // Navigate back after saving
//                        }
//                    }
//                }
//            )
//        }
        }
    }
}
