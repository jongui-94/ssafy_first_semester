package com.ssafy.memo

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.ssafy.memo.databinding.ActivityMainBinding

private const val TAG = "MainActivity_싸피"
class MainActivity : AppCompatActivity() {

    //private lateinit var viewMemo: TextView
    //private lateinit var mainMemo: TextView
    //private lateinit var editMainTitle: EditText
    //private lateinit var registerMemo: Button
    //private lateinit var showMemo: Button

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //setContentView(R.layout.activity_main)
        //viewMemo = findViewById(R.id.viewMemo)
        //mainMemo = findViewById(R.id.mainMemo)
        //editMainTitle = findViewById(R.id.editMainTitle)
        //registerMemo = findViewById(R.id.registerMemo)
        //showMemo = findViewById(R.id.showMemo)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.registerMemo.setOnClickListener {
            val intent = Intent(this, MemoEditActivity::class.java)
            intent.putExtra("name", "ssafy")

            startActivity(intent)
        }

        binding.showMemo.setOnClickListener {
            val intent = Intent(this, MemoInfoActivity::class.java)
            intent.putExtra("name", "ssafy")

            startActivity(intent)
        }
    }
    private val MemoEditActivityLauncher: ActivityResultLauncher<Intent> = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
        if(it.resultCode == Activity.RESULT_OK) {
            val intent = it.data
            val returnValue = intent!!.getStringExtra("dd")
            binding.editMainTitle.setText(returnValue)
        }
    }
}