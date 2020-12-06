package com.example.currentscape

import android.app.Application
import io.realm.Realm

class CurrentScapeApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        // Initialize MongoDB Realm application
        Realm.init(this)
    }
}