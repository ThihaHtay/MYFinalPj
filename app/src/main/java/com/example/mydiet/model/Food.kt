package com.example.mydiet.model

data class FoodInfo(
    var foodList: ArrayList<Food> = arrayListOf()
)

data class Food(
    var name:String="",
    var calory: String="",
    var image: String="",
    var category: String = ""
){
    constructor():this("","","",""){

    }
}