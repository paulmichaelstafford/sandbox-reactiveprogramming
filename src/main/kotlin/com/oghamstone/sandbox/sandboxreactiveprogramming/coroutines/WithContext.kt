package com.oghamstone.sandbox.sandboxreactiveprogramming.coroutines

import kotlinx.coroutines.*
import kotlin.random.Random

class WithContext {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val t = WithContext()
            t.main()
        }
    }
    suspend fun retrieve1(url: String) = coroutineScope {
        async(Dispatchers.IO) {
            println("Retrieving data on ${Thread.currentThread().name}")
            delay(100L)
            "asyncResults"
        }.await()
    }
    suspend fun retrieve2(url: String) =
        withContext(Dispatchers.IO) {
            println("Retrieving data on ${Thread.currentThread().name}")
            delay(100L)
            "withContextResults"
        }
    fun main() = runBlocking {
        val result1 = retrieve1("www.mysite.com")
        val result2 = retrieve2("www.mysite.com")
        println("printing result on ${Thread.currentThread().name} $result1")
        println("printing result on ${Thread.currentThread().name} $result2")
    }
}