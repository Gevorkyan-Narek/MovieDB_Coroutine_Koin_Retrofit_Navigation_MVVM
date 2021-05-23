package com.example.moviedb.data

import java.sql.Timestamp
import java.util.*

fun String.toTimestamp(): Timestamp = Timestamp.valueOf(this.dropLast(4))
fun Timestamp.isValid(): Boolean = after(Date())