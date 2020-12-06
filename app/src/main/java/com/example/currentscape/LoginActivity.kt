package com.example.currentscape

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import io.realm.mongodb.App
import io.realm.mongodb.AppConfiguration
import io.realm.mongodb.Credentials
import io.realm.mongodb.User

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val app = App(AppConfiguration.Builder(resources.getString(R.string.mongodb_app_id)).build())

        val credentials = Credentials.apiKey("0TpFxviC13Dd1MvB3TC02y4drA6ZgbZ1It3yYVqTxnklSbIBwd8AMF3p18guSN5O")

        app.loginAsync(credentials) {
            if (it.isSuccess) {
                Log.v("LoginActivity", "Successfully authenticated anonymously.")
                val user: User? = app.currentUser()
                Toast.makeText(applicationContext, "Logged In", Toast.LENGTH_SHORT).show()
            } else {
                Log.e("LoginActivity", "Failed to log in. Error: ${it.error}")
                Toast.makeText(applicationContext, "Cannot login!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}