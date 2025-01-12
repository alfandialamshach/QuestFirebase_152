package com.example.firebaseandroid.navigasi

interface DestinasiNavigasi{
    val  route : String
    val titleRes: String
}
object DestinasiHome : DestinasiNavigasi{
    override val route: String = "home"
    override val titleRes: String = "Home Mahasiswa"
}
object DestinasiInsert : DestinasiNavigasi{
    override val route: String = "insert"
    override val titleRes: String = "Insert"
}