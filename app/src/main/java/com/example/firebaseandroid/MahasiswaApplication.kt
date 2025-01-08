package com.example.firebaseandroid

import android.app.Application
import com.example.firebaseandroid.dependencies.AppContainer
import com.example.firebaseandroid.dependencies.MahasiswaContainer

class MahasiswaApplications: Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container= MahasiswaContainer()
    }
}