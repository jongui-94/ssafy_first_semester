package com.ssafy.memo

val dx: Array<Int> = arrayOf(0,-1,1,0,0)
val dy: Array<Int> = arrayOf(0,0,0,-1,1)

data class salt(val x: Int, val y: Int, val dir: Int)

private lateinit var salts: Array<salt>
private lateinit var map: Array<BooleanArray>

fun main() {
    val br = System.`in`.bufferedReader()
    val t = br.readLine()!!.toInt()

    for(tc in 1.. t){
        val (n, num) = br.readLine()!!.split(" ").map{it.toInt()}

        salts = Array(num){salt(0,0,0)}
        map = Array(n){ BooleanArray(n)}
        var live = 0

        for(i in 0 until num){
            val (x,y,dir) = br.readLine()!!.split(" ").map{it.toInt()}
            salts[i] = salt(x,y,dir)
            map[x][y] = true
        }

        for(salt in salts){
            var (x, y, dir) = salt
            map[x][y] = false

            for(j in 3 downTo 1 step 1){
                val curx = x + dx[dir] * j
                val cury = y + dy[dir] * j

                if(curx !in 0 until n || cury !in 0 until n) break

                if(map[curx][cury]) break

                if(j == 1){
                    map[curx][cury] = true
                    live++
                }
                x = curx
                y = cury
            }
        }

        println("#$tc $live")
    }


}