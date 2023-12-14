package com.fikri.resepmasakan

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.fikri.resepmasakan.ui.home.HomeFragment
import com.fikri.resepmasakan.ui.profil.ProfilFragment

class LoginActivity :AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        val usernameEdit  = findViewById<EditText>(R.id.editTextText2)
        val passwordEdit  = findViewById<EditText>(R.id.editTextTextPassword2)
        val loginButton = findViewById<Button>(R.id.button3)
        val register = findViewById<TextView>(R.id.textView18)

        loginButton.setOnClickListener(View.OnClickListener {
            val username = usernameEdit.text.toString()
            val password = passwordEdit.text.toString()
            val login = Intent(this, MainActivity::class.java)
            startActivity(login)
        })
        register.setOnClickListener(View.OnClickListener {
            val register = Intent(this, RegisterActivity::class.java)
            startActivity(register)
        })

    }

}