package com.example.sejaumguia.ui.main.interfaceImplementation

interface ServicesFailure {

    fun onResponseFailure(exception: Throwable)
    fun onFailure(t:Throwable)

}