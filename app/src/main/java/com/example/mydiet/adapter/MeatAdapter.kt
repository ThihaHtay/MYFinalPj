package com.example.mydiet.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.mydiet.R
import com.example.mydiet.model.Fruit
import com.example.mydiet.model.Meat
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fruit_calories.view.*
import kotlinx.android.synthetic.main.meat_calories.view.*

class MeatAdapter (val mCtx: Context, val layoutResId: Int, val meatList: List<Meat>):
    ArrayAdapter<Meat>(mCtx,layoutResId,meatList){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val layoutInflater: LayoutInflater = LayoutInflater.from(mCtx)
        val view: View = layoutInflater.inflate(layoutResId, null)

        val meatName=view.findViewById<TextView>(R.id.textMeatName)
        val meatCalory=view.findViewById<TextView>(R.id.textMeatCalory)
        val meatImage=view.findViewById<ImageView>(R.id.image_meat)
        val meats= meatList[position]

        meatName.text=meats.name
        meatCalory.text=meats.calory

        Picasso.get()
            .load(meats.image)
            .placeholder(R.drawable.loading)
            .into(view.image_meat)
        return view
    }

}