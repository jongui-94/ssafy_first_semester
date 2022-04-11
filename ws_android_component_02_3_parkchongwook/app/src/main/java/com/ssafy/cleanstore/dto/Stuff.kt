package com.ssafy.cleanstore.dto

data class Stuff (var name: String?, var count: Int) {
    override fun toString(): String {
        return "물품 : $name -> 수량 : $count"
    }
}