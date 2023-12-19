package com.fikri.resepmasakan

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.fikri.resepmasakan.api.ApiConfig
import com.fikri.resepmasakan.model.ResponModel
import com.fikri.resepmasakan.ui.home.HomeFragment
import com.fikri.resepmasakan.ui.profil.ProfilFragment
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity :AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)


        val loginButton = findViewById<Button>(R.id.button3)
        val register = findViewById<TextView>(R.id.textView18)

        loginButton.setOnClickListener {
            login()
        }


        register.setOnClickListener(View.OnClickListener {
            val register = Intent(this, RegisterActivity::class.java)
            startActivity(register)
        })

    }

    fun login() {
        val usernameEdit  = findViewById<EditText>(R.id.editTextText2)
        val passwordEdit  = findViewById<EditText>(R.id.editTextTextPassword2)

        if (usernameEdit.text.isEmpty()) {
            usernameEdit.error = "Username Wajib Di isi!"
            usernameEdit.requestFocus()
            return
        } else if (passwordEdit.text.isEmpty()) {
            passwordEdit.error = "Password Wajib Di isi!"
            passwordEdit.requestFocus()
            return
        }

        ApiConfig.instanceRetrofit.login(usernameEdit.text.toString(),passwordEdit.text.toString()).enqueue(object :
            Callback<ResponModel> {
            override fun onFailure(call: Call<ResponModel>, t: Throwable) {
                Toast.makeText(this@LoginActivity, "Error:" + t.message, Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<ResponModel>, response: Response<ResponModel>) {
                val respon =response.body() !!
                if (respon.status == 200){
                    Toast.makeText(this@LoginActivity, "Login Berhasil, Gass Ke Beranda", Toast.LENGTH_SHORT).show()
                    Handler(Looper.getMainLooper()).postDelayed({
                        val intent = Intent(this@LoginActivity,MainActivity::class.java)
                        startActivity(intent)
                        finish()  // Menutup aktivitas saat ini agar pengguna tidak dapat kembali ke halaman pendaftaran
                    }, 1000)

                }else {
                    Toast.makeText(this@LoginActivity, respon.message, Toast.LENGTH_SHORT).show()

                }
            }


        })


    }

}