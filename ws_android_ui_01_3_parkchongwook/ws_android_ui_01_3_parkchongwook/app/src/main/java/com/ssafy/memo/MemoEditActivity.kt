package com.ssafy.memo

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.ssafy.memo.databinding.ActivityMemoEditBinding

class MemoEditActivity : AppCompatActivity() {

    //private lateinit var toDo: TextView
    //private lateinit var detail: TextView
    //private lateinit var toDoEdit: EditText
    //private lateinit var detailEdit: EditText
    //private lateinit var save: Button
    //private lateinit var cancel: Button

    private lateinit var binding: ActivityMemoEditBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //setContentView(R.layout.activity_memo_edit)
        //toDo = findViewById(R.id.toDo)
        //detail = findViewById(R.id.detail)
        //toDoEdit = findViewById(R.id.toDoEdit)
        //detailEdit = findViewById(R.id.detailEdit)
        //save = findViewById(R.id.save)
        //cancel = findViewById(R.id.cancel)

        binding = ActivityMemoEditBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.save.setOnClickListener {
            val title : String = binding.toDoEdit.text.toString().trim()
            val content: String = binding.detailEdit.text.toString().trim()

            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("dd", title)

            if(title.isEmpty() || content.isEmpty()) {
                Toast.makeText(this, "모든 항목에 기입해주세요", Toast.LENGTH_LONG).show()
            }
            else{
                startActivity(intent)
            }
        }

        binding.cancel.setOnClickListener {
            finish()
        }
    }
}