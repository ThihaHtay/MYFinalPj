package com.example.mydiet.adapter

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.mydiet.R
import com.example.mydiet.model.Fruit
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fruit_calories.view.*
import org.w3c.dom.Text

class FruitAdapter (val mCtx: Context,val layoutResId: Int,val fruitList: List<Fruit>):
        ArrayAdapter<Fruit>(mCtx,layoutResId,fruitList){

    override fun getView(position: Int,convertView: View?, parent:ViewGroup):View{

        val layoutInflater: LayoutInflater= LayoutInflater.from(mCtx)
        val view: View= layoutInflater.inflate(layoutResId, null)

        val fruitName=view.findViewById<TextView>(R.id.textFruitName)
        val fruitCalory=view.findViewById<TextView>(R.id.textFruitCalory)
        val fruitImage=view.findViewById<ImageView>(R.id.image_fruit)
        val fruits= fruitList[position]

        fruitName.text=fruits.name
        fruitCalory.text=fruits.calory

        Picasso.get()
            .load(fruits.image)
            .placeholder(R.drawable.loading)
            .into(view.image_fruit)
        return view
    }

}