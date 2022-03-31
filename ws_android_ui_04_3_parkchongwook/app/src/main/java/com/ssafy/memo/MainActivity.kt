package com.ssafy.memo

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {

    // MemoItemMgr
    private lateinit var memoItemMgr: IMemoItemMgr

    // ListView에 들어갈 String List
    private lateinit var listViewItems: ArrayList<String>

    // ListView
    private lateinit var listView: ListView

    // 등록버튼
    //private lateinit var btnCreate: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.listView)
        //btnCreate = findViewById(R.id.btnCreate)

        // 초기 Memo 생성
        memoItemMgr = MemoItemMgr()
        memoItemMgr.add(MemoItem("메모 앱 만들기1", "메모 앱 서로 연결하기","03-29 03:19"))
        memoItemMgr.add(MemoItem("메모 앱 만들기2", "메모 앱 UI 만들기","03-30 05:22"))
        memoItemMgr.add(MemoItem("메모 앱 만들기3", "메모 앱 설계하기","03-31 10:30"))

        updateListViewItems()
        updateListView()

        // 등록 버튼과 리스트 항목을 터치할 때 사용할 Intent 객체 생성
        val intent = Intent(this, MemoEditActivity::class.java)

        // 신규 메모를 등록하기 위해 MemoEditActivity로 이동
//        btnCreate.setOnClickListener {
//            intent.putExtra("Title", "")
//            intent.putExtra("Content", "")
//            intent.putExtra("Date", "")
//            intent.putExtra("Num", -1)
//            memoEditActivityLauncher.launch(intent)
//        }

        // ListView에서 클릭한 Item에 들어있는 메모 데이터를 MemoEditActivity로 넘기기
        listView.setOnItemClickListener { parent, view, position, id ->
            intent.putExtra("Title", memoItemMgr.memos[position].title)
            intent.putExtra("Content", memoItemMgr.memos[position].content)
            intent.putExtra("Date", memoItemMgr.memos[position].date)
            intent.putExtra("Num", position)
            memoEditActivityLauncher.launch(intent)
        }

        registerForContextMenu(listView)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {

        menuInflater.inflate(R.menu.menu_context, menu)
        super.onCreateContextMenu(menu, v, menuInfo)

    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        val info: AdapterView.AdapterContextMenuInfo = item.menuInfo as AdapterView.AdapterContextMenuInfo
        when(item.itemId){
            R.id.delete_memo-> {
                memoItemMgr.remove(info.position)
                updateListView()
            }
        }
        return super.onContextItemSelected(item)
    }
    //option menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_option, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.option_menu_create) {
            val intent = Intent(Intent(this@MainActivity, MemoEditActivity::class.java))
            intent.putExtra("actionType", "save")
            memoEditActivityLauncher.launch(intent)
        }
        return super.onOptionsItemSelected(item)
    }

    // memoItemMgr 내용을 가지고 listViewItems 내용 업데이트
    private fun updateListViewItems() {
        // 새 리스트 만들기
        listViewItems = arrayListOf()

        // 메모 매니저에 있는 메모의 제목과 날짜를 조합하여 listViewItems에 담는다.
        for (i: Int in 0 until memoItemMgr.size()) {
            val title = memoItemMgr.memos[i].title
            val date = memoItemMgr.memos[i].date
            listViewItems.add("$title $date")
        }
    }

    // ListView와 Adapter 연결하고 ListView 내용 갱신하기
    private fun updateListView() {
        // Adapter 생성
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listViewItems)

        // ListView와 Adapter 연결
        listView.adapter = adapter

        // ListView 변경 적용
        adapter.notifyDataSetChanged()
    }

    // MemoEditActivity에서 MainActivity로 돌아올 때 수행할 작업
    private val memoEditActivityLauncher: ActivityResultLauncher<Intent> = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
        if (it.resultCode == Activity.RESULT_OK) {
            val intent: Intent? = it.data

            val title = intent!!.getStringExtra("OTitle").toString()
            val content = intent.getStringExtra("OContent").toString()
            val date = intent.getStringExtra("ODate").toString()
            val num = intent.getIntExtra("ONum",0)

            //state 0 : 등록 1 : 수정 2 : 삭제
            val state = intent.getIntExtra("OState",0)

            // 받아온 값으로 MemoItem 생성
            val m = MemoItem(title, content, date)

            // 수정 일 때 아닐때
            when (state) {
                0 -> memoItemMgr.add(m)//등록
                1 -> memoItemMgr.update(num, m)//수정
                2 -> memoItemMgr.remove(num)
            }

            updateListViewItems()
            updateListView()
        }
    }

}