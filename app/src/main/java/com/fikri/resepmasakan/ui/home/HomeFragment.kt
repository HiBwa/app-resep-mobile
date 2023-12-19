package com.fikri.resepmasakan.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.fikri.resepmasakan.R
import com.fikri.resepmasakan.ViewDetail
import com.fikri.resepmasakan.api.ApiConfig
import com.fikri.resepmasakan.databinding.FragmentHomeBinding
import com.fikri.resepmasakan.model.ResponUser
import com.google.gson.annotations.SerializedName
import javax.security.auth.callback.Callback

class HomeFragment : Fragment() {

    private val list = ArrayList<ResponUser>()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_home, container, false)

        val detailButton: Button = view.findViewById(R.id.button2)


        detailButton.setOnClickListener {
            // Intent to navigate to DetailView activity
            val intent = Intent(requireContext(), ViewDetail::class.java)

            // You can add any extra data to the intent if needed
            // intent.putExtra("key", "value")

            // Start the DetailView activity
            startActivity(intent)
        }



        return view
    }
}