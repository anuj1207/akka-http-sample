package com.combat.code.models

case class User(user_Id:Int,contact:Int,user_Name:String)
case class Station(station_Id:Int,station_Address:String,total_Points:Int,x_cordinate:Int,y_cordinate:Int)
case class Slot(slotId:Int,time:String)
case class Booking(booking_id:Int,station_id:Int,user_id:Int,slot_id:Int,date:String)