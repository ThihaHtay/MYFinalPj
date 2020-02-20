package com.example.mydiet.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.mydiet.R
import com.example.mydiet.model.Food
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.juice_calories.view.*


class JuiceAdapter (val juiceList: ArrayList<Food>):RecyclerView.Adapter<JuiceAdapter.JuiceViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JuiceViewHolder {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_juice,parent,false)
    return JuiceViewHolder(view)
    }

    override fun getItemCount(): Int {
       return juiceList.size
    }

    override fun onBindViewHolder(holder: JuiceViewHolder, position: Int) {

        holder.bindFood(juiceList.get(position))
        holder.btncountjuice.setOnClickListener{
            var count: Int = holder.juiceCount.toString().toInt()
            count++
            holder.juiceCount.text=count.toString()
        }

    }
    inner class JuiceViewHolder(itemView: View):
            RecyclerView.ViewHolder(itemView){
        private var view: View = itemView
        private lateinit var food: Food
        var btncountjuice = itemView.findViewById<Button>(R.id.btn_countjuice)
        var juiceCount = itemView.findViewById<TextView>(R.id.txt_juice_count)
        fun bindFood(food: Food){
            this.food= food
            Picasso.get()
                .load(food.image)
                .placeholder(R.drawable.loading)
                .into(view.image_juice)
            view.juice_name.text=food.name
            view.juice_category.text=food.category
            view.juice_calories.text=food.calory.toString()
        }
    }

}


