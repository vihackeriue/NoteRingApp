package com.example.noteringapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.noteringapp.Models.Note
import com.example.noteringapp.databinding.ActivityAddNoteBinding
import com.example.noteringapp.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.*
import java.util.logging.SimpleFormatter

class AddNote : AppCompatActivity() {
    private lateinit var binding: ActivityAddNoteBinding
    private lateinit var note: Note
    private lateinit var old_note: Note
    var isUpdate = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        try {
            old_note = intent.getSerializableExtra("current_note") as Note
            binding.editTitle.setText(old_note.title)
            binding.editNote.setText(old_note.content)
            isUpdate = true
        }catch (e : java.lang.Exception){
            e.printStackTrace()
        }
        binding.imgChecked.setOnClickListener{
            val title =  binding.editTitle.text.toString()
            val content = binding.editNote.text.toString()

            if(title.isNotEmpty() || content.isNotEmpty()){
                val formatter = SimpleDateFormat("EEE , d MMM yyyy HH:mm a")

                if(isUpdate){
                    note = Note(old_note.id, title, content, formatter.format(Date()))
                }else
                {
                    note = Note(null, title, content, formatter.format(Date()))
                }

                val intent = Intent()
                intent.putExtra("note", note)
                setResult(Activity.RESULT_OK, intent)
                finish()
            } else {
                Toast.makeText(this@AddNote, "Không được để trống", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
        }
        binding.imgBack.setOnClickListener{
            onBackPressed()
        }
    }
}