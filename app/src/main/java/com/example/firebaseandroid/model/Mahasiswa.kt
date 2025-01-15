package com.example.firebaseandroid.model

data class Mahasiswa (
    val nim: String,
    val nama: String,
    val alamat: String,
    val jenis_kelamin: String,
    val kelas: String,
    val angkatan: String,
    val dospem1: String,
    val dospem2: String,
    val judulSripsi: String
)
{
    constructor(
    ): this ("","","","","","","","","")
}