package com.wu.material.util.room

import androidx.room.Database
import androidx.room.RoomDatabase


/**
 * @author wkq
 *
 * @date 2022年05月06日 14:01
 *
 *@des
 *
 */
@Database(entities = [UserInfo::class],version = 1)
 abstract  class AppDatabase:RoomDatabase() {

}