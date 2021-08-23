package com.cursoandroid.notarapida

import android.content.Context
import android.content.SharedPreferences

class MyPreferences(c: Context) {
    private var context: Context = c
    private var preferences: SharedPreferences
    private var editor: SharedPreferences.Editor

    private val NOME_ARQUIVO: String = "preferencias"
    private val CHAVE_NOME: String = "anotacao"

    init {
        preferences = context.getSharedPreferences(NOME_ARQUIVO, 0)
        editor = preferences.edit()
    }

    fun setValue(anotacao: String){
        editor.putString(CHAVE_NOME, anotacao)
        editor.commit()
    }

    fun getValue(): String {
        return preferences.getString(CHAVE_NOME, "").toString()
    }
}