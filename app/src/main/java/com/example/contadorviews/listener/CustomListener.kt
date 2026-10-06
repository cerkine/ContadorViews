package com.example.contadorviews.listener

interface CustomListener {

    fun function()

    fun apply(){
        function()
    }
}