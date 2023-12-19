package com.fikri.resepmasakan.ui.profil

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.fikri.resepmasakan.LoginActivity
import com.fikri.resepmasakan.MainActivity
import com.fikri.resepmasakan.R
import com.fikri.resepmasakan.RegisterActivity
import com.fikri.resepmasakan.api.ApiConfig
import com.fikri.resepmasakan.databinding.FragmentProfilBinding
import com.fikri.resepmasakan.model.ResponModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfilFragment : Fragment() {

    lateinit var btnLogout: ImageButton

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_profil, container, false)
        btnLogout = view.findViewById(R.id.logout)
        btnLogout.setOnClickListener {
            logout()
        }


        return view
    }
    fun  logout(){
        val token = "t1VPjggRmzmy9O7obgOvceAf"
        ApiConfig.instanceRetrofit.logout(token).enqueue(object : Callback<ResponModel> {
            override fun onResponse(call: Call<ResponModel>, response: Response<ResponModel>) {
                val respon =response.body() !!
                if (respon.status ==200){
                    Toast.makeText(activity, "Berhasil Logout", Toast.LENGTH_SHORT).show()

                    val intent = Intent(activity, LoginActivity::class.java)
                    startActivity(intent)
                    activity?.finish() // Menutup fragment dan aktivitas saat ini
                } else {
                    Toast.makeText(activity, respon.message, Toast.LENGTH_SHORT).show()
                }
                Toast.makeText(activity, respon.message, Toast.LENGTH_SHORT).show()
            }

            override fun onFailure(call: Call<ResponModel>, t: Throwable) {
                Toast.makeText(activity, "Error:" + t.message, Toast.LENGTH_SHORT).show()
            }
        })
    }


}