package com.ssafy.ssafygo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import com.ssafy.ssafygo.dao.StoreDAO
import com.ssafy.ssafygo.dto.StoreDTO
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var sendBtn: Button

    private lateinit var storeLayout: LinearLayout
    private lateinit var storeNameTV: TextView
    private lateinit var storeTelTV: TextView
    private lateinit var storeLatTV: TextView
    private lateinit var storeLngTV: TextView

    private lateinit var waitTV: TextView
    private lateinit var progressBar: ProgressBar
    private lateinit var progressTV: TextView

    private val PROGRESS_CNT = 10
    private val PROGRESS_TICK = 300

    private val random = Random()

    //DB선언부
    private val storeDao = StoreDAO()
    private val STORE_ID = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initDAO()

        sendBtn = findViewById(R.id.btn_main_cnt_start)
        storeLayout = findViewById(R.id.linear_layout_store_info_layout)
        storeNameTV = findViewById(R.id.tv_store_name)
        storeTelTV = findViewById(R.id.tv_store_tel)
        storeLatTV = findViewById(R.id.tv_store_lat)
        storeLngTV = findViewById(R.id.tv_store_lng)

        waitTV = findViewById(R.id.tv_main_res_text)
        progressBar = findViewById(R.id.progressBar)
        progressTV = findViewById(R.id.tv_main_progress_text)

        // 가맹점 정보 결과 Layout 숨기기
        storeLayout.visibility = View.INVISIBLE
        waitTV.text = "준비 완료"

        sendBtn.setOnClickListener {
            loadStore()
        }
    }

    // 가맹점 정보 가져오기
    private fun getStoreInfo(): StoreDTO? {
        return storeDao.storeSelect(STORE_ID)
    }

    // DAO 초기화
    private fun initDAO() {
        storeDao.dbOpenHelper(this)
        storeDao.open()
    }

    private fun loadStore() = CoroutineScope(Dispatchers.Main).launch {
        // 가맹점 정보 결과 Layout 숨기기
        storeLayout.visibility = View.INVISIBLE

        progressBar.progress = 0
        // 버튼 클릭 시 버튼 비활성화
        sendBtn.isEnabled = false
        waitTV.text = "불러오는 중입니다..."

        // 데이터를 얻는데 시간이 빠르므로 임의의 시간동안 로딩하는 것 처럼 보여준다.
        val job = launch {
            var center: Int
            for (i in PROGRESS_CNT downTo 1) {
                // 주어진 범위에서 랜덤하게 진행률 채워나가기
                center = (progressBar.max - progressBar.progress) / i
                progressBar.incrementProgressBy(rand(center / 2, 3 * center / 2))
                progressTV.text = progressBar.progress.toString()
                delay(PROGRESS_TICK.toLong())
            }
            // 최종적으로는 100으로 표기
            progressBar.progress = progressBar.max
            progressTV.text = progressBar.progress.toString()
        }

        // ProgressBar 완료 될 때 까지 wait
        job.join()

        // 진행률 다 찼을 경우 버튼 재 활성화
        sendBtn.isEnabled = true
        setStoreTV()
    }

    // 가맹점 정보 표시
    private fun setStoreTV() {
        val store = getStoreInfo()
        if (store != null) {
            waitTV.text = "불러오기 완료!!"
            storeNameTV.text = store.name
            storeTelTV.text = store.tel
            storeLatTV.text = "위도 : ${store.lat}"
            storeLngTV.text = "경도 : ${store.lng}"
            storeLayout.visibility = View.VISIBLE
        }
        else {
            waitTV.text = "불러오지 못했습니다"
        }
    }

    // ProgressBar Random하게 증가시키기
    private fun rand(end: Int, start: Int): Int{
        return random.nextInt(start - end) + end
    }
}