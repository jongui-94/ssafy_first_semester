package com.ssafy.cleanstore.dto

data class Stuff (var name: String?, var count: Int) {
    override fun toString(): String {
        return "λ¬Όν : $name -> μλ : $count"
    }
}