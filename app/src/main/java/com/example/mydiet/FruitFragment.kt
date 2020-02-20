package com.example.mydiet


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import com.example.mydiet.adapter.FruitAdapter
import com.example.mydiet.model.Fruit
import com.google.firebase.database.*

/**
 * A simple [Fragment] subclass.
 */
class FruitFragment : Fragment() {

    //For Show
    lateinit var listView: ListView
    lateinit var fruitList: MutableList<Fruit>
    lateinit var ref: DatabaseReference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root= inflater.inflate(R.layout.fragment_fruit, container, false)
        listView=root.findViewById(R.id.listView)

        return root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //For Show
        fruitList= mutableListOf()
        ///
        ref = FirebaseDatabase.getInstance().getReference("fruit")

        //For Show
        ref.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onDataChange(p0: DataSnapshot) {
                if (p0!!.exists()){
                    fruitList.clear()

                    for (u in p0.children){
                        val users=u.getValue(Fruit::class.java)
                        fruitList.add(users!!)

                        Log.d("User Firebase>>>>>", users.toString())
                    }

                    val adapter=FruitAdapter(context!!,R.layout.fruit_calories,fruitList)
                    listView.adapter=adapter

                }
            }

        })
    }


}
