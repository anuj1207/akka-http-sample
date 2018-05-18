package com.combat.code.models

import java.util

case class User(contact: Int, user_Name: String, user_Id: Int = 0)

case class Station(station_Id: Int, station_Address: String, total_Points: Int, x_cordinate: Int, y_cordinate: Int)

case class Slot(slotId: Int, time_slot: String)

case class Booking( station_id: Int, user_id: Int, slot_id: Int, date: String,booking_id: Int)

case class BookingSlot(slot: Slot, bookingCounter: Int)

case class StationJSON(station: Station, bookingSlotList: util.LinkedList[BookingSlot])