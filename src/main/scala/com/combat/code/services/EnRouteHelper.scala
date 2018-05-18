package com.combat.code.services

import java.util.HashMap

import com.combat.code.models.{Booking, Slot, Station}
import com.combat.code.repos.{BookingRepo, SlotRepo}

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object EnRouteHelper {
  def findStationsBetweenCities(from: String, to: String, date: String): Future[Map[Station, Map[Slot, Int]]] = {
    val stationList = List(1, 2, 3).flatMap(DBHelper.getStationById)
    val bookings: Future[List[Seq[Booking]]] = Future.sequence(stationList.map(station => BookingRepo.getBookingForStationsAndDate(station.station_Id, date)))

    val slotMap: Future[Map[Station, Map[Slot, Int]]] = SlotRepo.getAllSlots.flatMap{ slots =>
      bookings.map{ bookingList =>
        stationList.zip(bookingList).toMap.mapValues(booking => slots.zip(slots.map(slot => booking.count(_.slot_id == slot.slotId))).toMap)
      }
    }

    val slotMap1: Future[Map[Station, List[Slot]]] = SlotRepo.getAllSlots.map{ slots =>
      stationList.map((_, slots)).toMap
    }
    slotMap
  }

  def calculateDistance(from: (Int, Int), to: (Int, Int)): Int = {
    ??? //Code combat 3.0
  }

  def getSlotMap(stationList: List[Station],
                  slotList: List[Slot],
                  bookingList: List[Booking]): HashMap[Station, HashMap[Slot, Integer]] = {
    val returnMap: HashMap[Station, HashMap[Slot, Integer]] =
      new HashMap[Station, HashMap[Slot, Integer]]()
    for (s <- stationList) {
      val slotMap: HashMap[Slot, Integer] = new HashMap[Slot, Integer]()
      for (sl <- slotList) {
        var bookingCount: java.lang.Integer = 0
        for (b <- bookingList
             if b.station_id == s.station_Id && b.slot_id == sl.slotId) {
          { bookingCount += 1; bookingCount - 1 }
        }
        slotMap.put(sl, bookingCount)
      }
      returnMap.put(s, slotMap)
    }
    returnMap
  }

}
