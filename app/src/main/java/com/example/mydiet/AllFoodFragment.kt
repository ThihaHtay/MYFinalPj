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
class AllFoodFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root: View = inflater.inflate(R.layout.fragment_all_food, container, false)
        var btnjuice =root.findViewById<Button>(R.id.btn_juice)
        var btnfruit=root.findViewById<Button>(R.id.btn_fruits)
        var btnmeat=root.findViewById<Button>(R.id.btn_meat)

        btnjuice.setOnClickListener{view:View->
            view.findNavController().navigate(R.id.action_allFoodFragment_to_juiceFragment)
        }

        btnfruit.setOnClickListener{view:View->
            view.findNavController().navigate(R.id.action_allFoodFragment_to_fruitFragment)
        }

        btnmeat.setOnClickListener{view:View->
            view.findNavController().navigate(R.id.action_allFoodFragment_to_meatFragment)
        }

        return root
    }


}
