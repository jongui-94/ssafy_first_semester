package com.ssafy.memo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MemoInfoActivity : AppCompatActivity() {

    private lateinit var memo1: EditText
    private lateinit var memo2: EditText
    private lateinit var memo3: EditText
    private lateinit var goBack: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_memo_info)

        memo1 = findViewById(R.id.memo1)
        memo2 = findViewById(R.id.memo2)
        memo3 = findViewById(R.id.memo3)
        goBack = findViewById(R.id.goBack)

        memo1.setText("메모 앱 만들기1 2022-03-28")
        memo2.setText("메모 앱 만들기2 2022-03-29")
        memo3.setText("메모 앱 만들기3 2022-03-30")

        goBack.setOnClickListener {
            finish()
        }

    }
}