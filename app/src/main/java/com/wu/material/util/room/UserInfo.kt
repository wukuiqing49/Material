package com.wu.material.util.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


/**
 * @author wkq
 *
 * @date 2022年05月06日 14:03
 *
 *@des
 *
 */
@Entity
data  class UserInfo (
    @PrimaryKey
    val uid: Int,
    @ColumnInfo(name = "first_name") val firstName: String?,
    @ColumnInfo(name = "last_name") val lastName: String?
    )