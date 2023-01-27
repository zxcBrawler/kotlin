package com.example.nierdatabasekotlin
import io.paperdb.Paper

class NierDBScheme {
    fun getCharacters(): ArrayList<Characters> {
        return Paper.book("chars").read("chars", ArrayList())!!
    }

    private fun saveCharList(char: ArrayList<Characters> ) {
        Paper.book("chars").write("chars", char)
    }

    fun addChar(char : Characters){
        val chars = getCharacters()
        chars.add(char)
        saveCharList(chars)
    }

    fun deleteChar(char : Characters) {
        val chars = getCharacters()
        chars.remove(char)
        saveCharList(chars)
    }
}