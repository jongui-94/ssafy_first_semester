package com.ssafy.memo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.ssafy.memo.util.Utils

class MemoEditActivity : AppCompatActivity() {

    private lateinit var editTodo: EditText
    private lateinit var editContent: EditText
    private lateinit var tvDate: TextView
    private lateinit var editDate: EditText

    private lateinit var btnSave: Button
    //private lateinit var btnDelete: Button
    private lateinit var btnCancel: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_memo_edit)

        editTodo = findViewById(R.id.editTodo)
        editContent = findViewById(R.id.editContent)
        tvDate = findViewById(R.id.tvDate)
        editDate = findViewById(R.id.editDate)

        btnSave = findViewById(R.id.btnSave)
        //btnDelete = findViewById(R.id.btnDelete)
        btnCancel = findViewById(R.id.btnCancel)

        // MainActivity로부터 전달받은 intent 객체의 Extra 가져오기
        val title = intent.getStringExtra("Title")
        val content = intent.getStringExtra("Content")
        val date = intent.getStringExtra("Date")
        val num = intent.getIntExtra("Num",0)

        // 전달받은 데이터를 EditText에 넣기
        editTodo.setText(title)
        editContent.setText(content)
        editDate.setText(date)

        // 수정모드일 경우 (전달받은 title 값이 비어있지 않으면)
        if (title!!.isNotEmpty()) {
            tvDate.visibility = View.VISIBLE
            editDate.visibility = View.VISIBLE
            //btnDelete.visibility = View.VISIBLE
            editTodo.isEnabled = false
            editDate.isEnabled = false
        }

        // 저장
        btnSave.setOnClickListener {

            // 현재 작성한 내용 가져오기
            val titleNew = editTodo.text.toString()
            val contentNew = editContent.text.toString()
            val dateNew = Utils.formatter().format(System.currentTimeMillis())

            // 값이 다 채워졌다면
            if (titleNew.isNotEmpty() && contentNew.isNotEmpty()) {

                // 값 전달 Intent 생성
                val intent = Intent(this, MainActivity::class.java)

                // 전달할 값 넣기
                intent.putExtra("OTitle", titleNew)
                intent.putExtra("OContent", contentNew)
                intent.putExtra("ODate", dateNew)
                intent.putExtra("ONum",num)

                // 등록
                if (title.isEmpty()) {
                    intent.putExtra("OState",0)
                }
                // 수정
                else {
                    intent.putExtra("OState",1)
                }

                setResult(RESULT_OK, intent)

                //해당 엑티비티 종료
                finish()

            }
            // 값이 채워지지 않았다면
            else {
                Toast.makeText(this, "모든 빈칸을 채워주세요", Toast.LENGTH_SHORT).show()
            }
        }

        // 삭제
//        btnDelete.setOnClickListener {
//            val intent = Intent(this, MainActivity::class.java)
//            intent.putExtra("ONum", num)
//            intent.putExtra("OState", 2)
//
//            setResult(RESULT_OK, intent)
//
//            //해당 엑티비티 종료
//            finish()
//        }

        // 취소
        btnCancel.setOnClickListener {

            // 해당 엑티비티 종료
            finish()
        }
    }
}