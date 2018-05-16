package com.combat.code.connection

import slick.jdbc.JdbcProfile

trait DBconnection {
  val driver:JdbcProfile
  import driver.api._
  val db:Database
}
