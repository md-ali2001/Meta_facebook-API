package com.example.chatgptapi_integration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.facebook.*
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.facebook.login.widget.LoginButton
import org.json.JSONObject

private fun LoginButton.registerCallback(callbackManager: CallbackManager, callback: FacebookCallback<LoginResult?>) {

}

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    lateinit var callbackManager: CallbackManager
    private val EMAIL = "email"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val loginButton = findViewById<LoginButton>(R.id.login_button)
        loginButton.setOnClickListener {
            loginButton.setReadPermissions(listOf(EMAIL))
            callbackManager = CallbackManager.Factory.create()
            // If you are using in a fragment, call loginButton.setFragment(this);
            // Callback registration
            // If you are using in a fragment, call loginButton.setFragment(this);
            // Callback registration
            loginButton.registerCallback(callbackManager, object : FacebookCallback<LoginResult?> {
                override fun onSuccess(loginResult: LoginResult?) {
                    Log.d("MainActivity", "Facebook token: " + loginResult!!.accessToken.token)
                    val graphRequest=GraphRequest.newMeRequest(loginResult.accessToken){`object` ,response->
                        getFacebookData(`object`)
                    }

                }
                override fun onCancel() { // App code
                }
                override fun onError(exception: FacebookException) { // App code
                }
            })
            callbackManager = CallbackManager.Factory.create()
            LoginManager.getInstance().registerCallback(callbackManager,
                object : FacebookCallback<LoginResult?> {
                    override fun onSuccess(loginResult: LoginResult?) {

                    // App code
                    }
                    override fun onCancel() { // App code
                    }
                    override fun onError(exception: FacebookException) { // App code
                    }

                }
                         )
        } }

    private fun getFacebookData(obj: JSONObject?) {
        TODO("Not yet implemented")
    }

}

private fun LoginManager.registerCallback(callbackManager: CallbackManager, callback: FacebookCallback<LoginResult?>) {

}
