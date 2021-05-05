package com.vkt4u9999.instagram

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.view.size
import com.vkt4u9999.instagram.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var mBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mBinding.bottomNavigationView.setTextVisibility(false)
                .enableItemShiftingMode(false)
                .enableShiftingMode(false)
                .enableAnimation(false)

        for (i in 0 until mBinding.bottomNavigationView.menu.size()) {
            mBinding.bottomNavigationView.setIconTintList(i, null)
        }

    }

    fun testInput(input: Any) {
        when (input) {
            1 -> println("One")
            2 -> println("Two")
            is String -> Log.d("String", "The length of input string is ${input.length}")
            in 1..10 -> Log.d("String", "From 1 to 10")
            else -> Log.d("String", "Something else")
        }
        val a = listOf(1, 2, 3, 4, 5)


        a.forEach { e -> Log.d("listof", "$e") }
        a.reduce { sum, e -> sum + e }
        a.filter { e -> e % 2 == 0 }
        a.map { e -> e * 2 }
        a.sortedByDescending { it }

        a.any { it > 10 }

        a.sum()

        val list = listOf(1, 3, -4, -11, 6, 12, -14)

        val (positive, negative) = list.partition { it > 0 }
        Log.d("partition", "$positive /n $negative")
    }

    class Person(val firstName: String, val lastName: String, var age: Int) {
        var children: MutableList<Person> = mutableListOf()
    }

    fun getRepeatedIntersection(a1: IntArray, a2: IntArray): List<Int> {

        val s1 = a1.toHashSet()
        val s2 = a2.toHashSet()
        val result = mutableListOf<Int>()

        for (el in s1) {
            if (s2.contains(el)) {
                val numberOfRepeat = minOf(a1.count { it == el }, a2.count { it == el })
                repeat(numberOfRepeat) { result.add(el) }
            }
        }
        return result
    }

    fun countLetters(str: String): String {

        var currentLetter = str[0]
        var count = 1
        var result = ""

        for (letter in str.substring(1)) {
            if (currentLetter == letter) {
                count++
            } else {
                if (count == 1) {
                    result += currentLetter
                } else {
                    result += "$currentLetter$count"

                    count = 1
                    currentLetter = letter
                }
            }
        }

        if (count == 1) {
            result += currentLetter
        } else
            result += "$currentLetter$count"

        return result
    }

    fun groupWords(words: Array<String>): List<List<String>> {

        val result: MutableList<List<String>> = mutableListOf()

        val map = mutableMapOf<String, MutableList<String>>()

        for (word in words) {
            val sortedWord = word.toCharArray().sorted().joinToString("")

            if (map.containsKey(sortedWord))
                map[sortedWord]?.add(word)
            else
                map[sortedWord] = mutableListOf(word)
        }
        for ((key, value) in map) {
            result.add(value)

        }
        return result
    }
}




