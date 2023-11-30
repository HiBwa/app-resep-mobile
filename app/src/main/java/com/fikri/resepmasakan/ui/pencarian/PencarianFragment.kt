package com.fikri.resepmasakan.ui.pencarian

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.fikri.resepmasakan.databinding.FragmentPencarianBinding

class PencarianFragment : Fragment() {

    private var _binding: FragmentPencarianBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val pencarianViewModel =
            ViewModelProvider(this).get(PencarianViewModel::class.java)

        _binding = FragmentPencarianBinding.inflate(inflater, container, false)
        val root: View = binding.root

        //val textView: TextView = binding.textPencarian
        pencarianViewModel.text.observe(viewLifecycleOwner) {
          //  textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}