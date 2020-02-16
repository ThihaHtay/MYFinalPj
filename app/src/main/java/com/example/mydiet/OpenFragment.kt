package com.example.mydiet


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController

/**
 * A simple [Fragment] subclass.
 */
class OpenFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root:View= inflater.inflate(R.layout.fragment_open, container, false)

        var btncalbmibmr = root.findViewById<Button>(R.id.btn_calbmibmr)

        var btnallfood=root.findViewById<Button>(R.id.btn_food)

        btncalbmibmr.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_openFragment_to_calculateFragment2)
        }
        btnallfood.setOnClickListener{view: View ->
            view.findNavController().navigate(R.id.action_openFragment_to_allFoodFragment)

        }


        return root

    }


}
