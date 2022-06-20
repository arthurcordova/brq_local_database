package com.mobwaysolutions.appdatabase

import android.view.View

fun main() {

    val nome : String = "Arthur"

    println(nome.concatenarSobrenome("Stapassoli"))

    println("Nova String".concatenarSobrenome("Qualquer nome"))

}


fun String.concatenarSobrenome(sobrenome: String) : String {
    return "$this - $sobrenome"
}

fun String.formatarCPF() : String {
    return ""
}

fun View.mostrar() {
    this.visibility = View.VISIBLE
}

fun View.esconder() {
    this.visibility = View.GONE
}
