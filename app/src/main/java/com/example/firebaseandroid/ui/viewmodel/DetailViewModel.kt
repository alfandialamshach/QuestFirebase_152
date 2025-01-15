package com.example.firebaseandroid.ui.viewmodel

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.firebaseandroid.model.Mahasiswa
import com.example.firebaseandroid.repository.MahasiswaRepository
import com.example.firebaseandroid.ui.view.DestinasiDetail
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart

import kotlinx.coroutines.launch
sealed class DetailUiState {
    data class Success(val mahasiswa: Mahasiswa) : DetailUiState()
    data class  Error(val exception: Throwable) : HomeUiState()
    object  Loading : DetailUiState()
}


class DetailMhsViewModel(
    savedStateHandle: SavedStateHandle,
    private val mhs: MahasiswaRepository
) : ViewModel() {

    // Retrieve the NIM from SavedStateHandle
    val nim: String = checkNotNull(savedStateHandle[DestinasiDetail.NIM])

    var mhsUIState: HomeUiState by mutableStateOf(HomeUiState.Loading)
        private set
    private val _detailUiState = MutableStateFlow<DetailUiState>(DetailUiState.Loading)
    val detailUiState: StateFlow<DetailUiState> = _detailUiState

    init {
        ambilMahasiswa()
    }

    // Fetch the student data using NIM
     fun ambilMahasiswa() {
        viewModelScope.launch {
            mhs.getMahasiswaByNim(nim)

                .onStart {
                    mhsUIState = HomeUiState.Loading
                }
                .catch {
                    mhsUIState = HomeUiState.Error(it)
                }

        }
    }


    // Update the mahasiswa information
    fun updateMhs(nim: String, mahasiswa: Mahasiswa) {
        viewModelScope.launch {
            try {
                mhs.updateMahasiswa(nim, mahasiswa)


            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}


fun Mahasiswa.toDetailUiEvent(): MahasiswaEvent {
    return MahasiswaEvent(
        nim = nim,
        nama = nama,
        jenis_kelamin = jenis_kelamin,
        alamat = alamat,
        kelas = kelas,
        angkatan = angkatan
    )
}

