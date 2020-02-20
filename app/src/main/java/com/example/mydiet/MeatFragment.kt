package com.example.mydiet


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import com.example.mydiet.adapter.FruitAdapter
import com.example.mydiet.adapter.MeatAdapter
import com.example.mydiet.model.Fruit
import com.example.mydiet.model.Meat
import com.google.firebase.database.*

/**
 * A simple [Fragment] subclass.
 */
class MeatFragment : Fragment() {
    lateinit var listView: ListView
    lateinit var meatList: MutableList<Meat>
    lateinit var ref: DatabaseReference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root= inflater.inflate(R.layout.fragment_meat, container, false)
        listView=root.findViewById(R.id.meatlistView)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //For Show
        meatList= mutableListOf()
        ///
        ref = FirebaseDatabase.getInstance().getReference("meat")

        //For Show
        ref.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onDataChange(p0: DataSnapshot) {
                if (p0!!.exists()){
                    meatList.clear()

                    for (u in p0.children){
                        val user=u.getValue(Meat::class.java)
                        meatList.add(user!!)

                        Log.d("User Firebase>>>>>", user.toString())
                    }

                    val adapter= MeatAdapter(context!!,R.layout.meat_calories,meatList)
                    listView.adapter=adapter

                }
            }

        })
    }


}
