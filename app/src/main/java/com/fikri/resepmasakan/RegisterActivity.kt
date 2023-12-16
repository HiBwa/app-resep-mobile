package com.fikri.resepmasakan

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.fikri.resepmasakan.api.ApiConfig
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.os.Looper
import android.os.Handler
import com.fikri.resepmasakan.model.ResponModel

class RegisterActivity :AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register)
        val registerButton = findViewById<Button>(R.id.buttonRegister)
        val login = findViewById<TextView>(R.id.textLogin)

//        menjalankan fungsi register
        registerButton.setOnClickListener {
            register()
        }

        login.setOnClickListener(View.OnClickListener {
            val login = Intent(this, LoginActivity::class.java)
            startActivity(login)
        })


    }
    fun register() {
        val namaEdit  = findViewById<EditText>(R.id.nama)
        val usernameEdit  = findViewById<EditText>(R.id.username)
        val noHP  = findViewById<EditText>(R.id.no_hp)
        val passwordEdit  = findViewById<EditText>(R.id.password)
        val email  = findViewById<EditText>(R.id.email)

    if (namaEdit.text.isEmpty()) {
            namaEdit.error = "Kolom Nama tidak boleh kosong"
            namaEdit.requestFocus()
            return
        } else if (usernameEdit.text.isEmpty()) {
            usernameEdit.error = "Kolom Email tidak boleh kosong"
            usernameEdit.requestFocus()
            return
        } else if (email.text.isEmpty()) {
            email.error = "Kolom Email tidak boleh kosong"
            email.requestFocus()
            return
        } else if (noHP.text.isEmpty()) {
            noHP.error = "Kolom Nomor Telepon tidak boleh kosong"
            noHP.requestFocus()
            return
        } else if (passwordEdit.text.isEmpty()) {
            passwordEdit.error = "Kolom Password tidak boleh kosong"
            passwordEdit.requestFocus()
            return
        }

        ApiConfig.instanceRetrofit.register(namaEdit.text.toString(),usernameEdit.text.toString(), email.text.toString(), noHP.text.toString(), passwordEdit.text.toString()).enqueue(object :Callback<ResponModel>{

            override fun onResponse(call: Call<ResponModel>, response: Response<ResponModel>) {

                val respon =response.body() !!

                if (respon.status == 200){
                    Toast.makeText(this@RegisterActivity, "Berhasil Membuat Akun, Silahkan Login", Toast.LENGTH_SHORT).show()
                    Handler(Looper.getMainLooper()).postDelayed({
                        val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
                        startActivity(intent)
                        finish()  // Menutup aktivitas saat ini agar pengguna tidak dapat kembali ke halaman pendaftaran
                    }, 2000)

                }else {
                    Toast.makeText(this@RegisterActivity, "Gagal :" + respon.message, Toast.LENGTH_SHORT).show()

                }




            }

            override fun onFailure(call: Call<ResponModel>, t: Throwable) {
                Toast.makeText(this@RegisterActivity, "Error:" + t.message, Toast.LENGTH_SHORT).show()
            }

        })


    }
}






