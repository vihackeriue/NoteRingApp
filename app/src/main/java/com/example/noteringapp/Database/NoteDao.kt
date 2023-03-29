package com.example.noteringapp.Database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.noteringapp.Models.Note

@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note: Note)

    @Delete
    suspend fun delete(note: Note)

    @Query("Select * from notes_table order by id ASC")
    fun getAllNote(): LiveData<List<Note>>

    @Query("UPDATE notes_table Set title = :title, content= :content WHERE id= :id")
    suspend fun update(id: Int? , title: String? , content: String?)
}