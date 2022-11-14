package com.example.madpractical11_20012021017

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Note
import android.view.View
import com.example.madpractical11_20012021017.databinding.ActivityNoteviewBinding

class noteview : AppCompatActivity() {
    private lateinit var binding: ActivityNoteviewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var note = intent.getSerializableExtra("Object") as Note

        binding = ActivityNoteviewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(note){
            binding.noteTitle.text = this.title
            binding.noteSubtitle.text = this.subTitle
            binding.noteContent.text =this.Description
            binding.noteDate.text = this.modifiedTime
            this. calcReminder()
            if (this.isReminder)
            {
                binding.noteReminderDateTime.visibility = View.VISIBLE
                binding.noteReminderDateTime.text = this.getReminderText()
            }
            else
            {
                binding.noteReminderDatetime.visibility = View.GONE
            }
        }
    }
}

