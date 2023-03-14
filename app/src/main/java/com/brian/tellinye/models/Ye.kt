package com.brian.tellinye.models

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "yeQuotesDb")
data class Ye(
    @PrimaryKey
    val id : Int = 0,
    val quote: String? = null
)