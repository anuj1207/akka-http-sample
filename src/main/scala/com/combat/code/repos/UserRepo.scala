package com.combat.code.repos

import com.combat.code.connection.{DBconnection, PostgresConnection}
import com.combat.code.models.User
import com.combat.code.tables.UserTable

trait UserRepo extends UserTable {
  this:DBconnection=>
  import driver.api._

  def create = db.run(userQuery.schema.create)

  def insert(user: User) = db.run(userQuery returning userQuery.map(_.user_id) += user)

  def delete(user_id: Int) = db.run {
    userQuery.filter(_.user_id === user_id).delete
  }

  def getAllUser = db.run {

    userQuery.to[List].result
  }


}
object UserRepo extends UserRepo with PostgresConnection