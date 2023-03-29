package com.example.noteringapp.Models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes_table")
data class Note (
    @PrimaryKey(autoGenerate = true) val id: Int?,
    @ColumnInfo(name = "title")  val title: String?,
    @ColumnInfo(name = "content") val content: String?,
    @ColumnInfo(name = "date") val date: String?,
): java.io.Serializable