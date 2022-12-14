package com.ssafy.cleanstore.stuff

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.play.core.internal.bo
import com.ssafy.cleanstore.R
import com.ssafy.cleanstore.databinding.ActivityStuffEditBinding
import com.ssafy.cleanstore.dto.Stuff
import java.text.DateFormat
import java.util.*

private const val TAG = "StuffEditActivity_싸피"
class StuffEditActivity : AppCompatActivity() {

    private lateinit var binding:ActivityStuffEditBinding
    private val dateShort = DateFormat.getDateInstance(DateFormat.SHORT, Locale.KOREA)
    private var cal = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStuffEditBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.cvStuffEditCalendar.date = cal.time.time
        binding.tvStuffEditCalendarToday.text = dateShort.format(Date(cal.timeInMillis))

        binding.cvStuffEditCalendar.date = cal.timeInMillis
        binding.cvStuffEditCalendar.setOnDateChangeListener{ view, year, month, dayOfMonth ->
            Log.d(TAG, "onCreate: $year $month $dayOfMonth")
            cal = Calendar.getInstance()
            cal.set(year, month, dayOfMonth)

            binding.tvStuffEditCalendarToday.text = dateShort.format(cal.time)
        }

        val today = Date()

        Log.d(TAG, "SHORT : ${dateShort.format(today)}")

        val etStuffName = findViewById<EditText>(R.id.et_stuff_edit_stuff_name)
        val etStuffCount = findViewById<EditText>(R.id.et_stuff_edit_stuff_count)

        val btnSave = findViewById<Button>(R.id.btn_stuff_edit_save)
        val btnDelete = findViewById<Button>(R.id.btn_stuff_edit_delete)
        val btnCancel = findViewById<Button>(R.id.btn_stuff_edit_cancel)

        // List에서 넘어오는 값
//        val name = intent.getStringExtra("Name")
//        val count = intent.getIntExtra("Count", -1)
        val stuff = intent.getSerializableExtra("stuff") as Stuff
        val position = intent.getIntExtra("Position", -1)
        val actionFlag = intent.getSerializableExtra("ActionFlag")

        when (actionFlag) {
            ActionFlag.REGISTER -> {
                btnDelete.visibility = View.GONE
            }
            ActionFlag.MODIFY -> {
                btnDelete.visibility = View.VISIBLE

                // 넘어온 값 보여주기
                etStuffName.setText(stuff.name)
                etStuffCount.setText(stuff.count.toString())
                binding.tvStuffEditCalendarToday.text = stuff.regDate
                var (y,m,d) = stuff.regDate.split('/').map{it.toInt()}
                y+= 2000
                cal.set(y,m,d)
                binding.cvStuffEditCalendar.date = cal.timeInMillis
            }
        }

        // 저장
        btnSave.setOnClickListener {

            // 값이 다 채워졌다면
            if (etStuffName.text.isNotEmpty() && etStuffCount.text.isNotEmpty()) {

                // 값 전달 Intent 생성
                Intent(this, StuffActivity::class.java).apply {

                    // 전달할 값 넣기
//                    putExtra("OName", etStuffName.text.toString())
//                    putExtra("OCount", etStuffCount.text.toString().toInt())
                    val stuff = Stuff(etStuffName.text.toString(), etStuffCount.text.toString().toInt(), dateShort.format(cal.time))
                    putExtra("stuff", stuff)
                    putExtra("OPosition", position)
                    putExtra("OActionFlag", actionFlag)
                    setResult(Activity.RESULT_OK, this)
                }

                // 해당 엑티비티 종료
                finish()
            }
            else {
                Toast
                    .makeText(this, "모든 빈칸을 채워주세요", Toast.LENGTH_SHORT)
                    .show()
            }
        }

        // 삭제
        btnDelete.setOnClickListener {

            // 값 전달 Intent 생성
            Intent(this, StuffActivity::class.java).apply {

                // 전달할값 넣기
                putExtra("OPosition", position)
                putExtra("OActionFlag", ActionFlag.DELETE)
                setResult(Activity.RESULT_OK, this)
            }

            // 해당 엑티비티 종료
            finish()
        }

        // 취소
        btnCancel.setOnClickListener {
            // 해당 엑티비티 종료
            finish()
        }
    }
}