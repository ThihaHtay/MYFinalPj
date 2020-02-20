package com.example.mydiet


import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.mydiet.adapter.JuiceAdapter
import com.example.mydiet.model.Food

import com.google.firebase.FirebaseApp
import com.google.firebase.database.*
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.*
import com.google.firebase.firestore.FirebaseFirestoreSettings as FirebaseFirestoreSettings


/**
 * A simple [Fragment] subclass.
 */
class JuiceFragment : Fragment() {

        lateinit var recyclerView: RecyclerView
        lateinit var foodList: ArrayList<Food>
        lateinit var ref: DatabaseReference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root= inflater.inflate(R.layout.fragment_juice, container, false)

        foodList= arrayListOf()

        ref = FirebaseDatabase.getInstance().getReference("fruit")
        recyclerView=root.findViewById(R.id.recycler_juice)



        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ref.addValueEventListener(object : ValueEventListener{
            override fun onCancelled(p0: DatabaseError){

            }

            override fun onDataChange(p0: DataSnapshot) {
                if (p0!!.exists()){
                    foodList.clear()

                    for(u in p0.children){
                        val foods=u.getValue(Food::class.java)
                        foodList.add(foods!!)
                    }

                    val adapter= JuiceAdapter(foodList as ArrayList<Food>)
                    recyclerView.adapter=adapter
                }
            }
        })
    }


}
