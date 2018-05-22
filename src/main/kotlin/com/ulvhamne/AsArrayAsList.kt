package com.ulvhamne

/**
 * This is the type com.ulvhamne.AsArrayAsList.
 *
 */
import java.util.Arrays

/**
 * This is the type com.ulvhamne.AsArrayAsList.
 *
 */
    fun main(args: Array<String>) {

        val strings = Arrays.asList(*"Hello world".split("(?!^)".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray())
        val strings2 = strings.toTypedArray()
        val strings3 = Arrays.asList(*strings2)
        val strings4 = strings3.toTypedArray()

        println(java.lang.Boolean.valueOf(strings === strings3))
        println(java.lang.Boolean.valueOf(strings2 === strings4))


        println(Arrays.asList(*strings4))


    }



