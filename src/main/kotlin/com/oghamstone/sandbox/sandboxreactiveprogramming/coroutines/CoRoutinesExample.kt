package com.oghamstone.sandbox.sandboxreactiveprogramming.coroutines

import kotlinx.coroutines.*
import kotlin.random.Random

class CoRoutinesExample {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val t = CoRoutinesExample()
            t.runBlocker()
            t.runLaunch()
            runBlocking{
                t.runAsync()
                t.coroutineScopeMethod()
            }
        }
    }
    fun runBlocker() {
        println("Before creating coroutine")
        runBlocking {
            print("Hello, ")
            delay(200L)
            println("World!")
        }
        println("After coroutine is finished")
    }
    fun runLaunch() {
        println("Before runBlocking")
        runBlocking {
            println("Before launch")
            launch {
                print("Hello, ")
                delay(200L)
                println("World!")
            }
            println("After launch")
        }
        println("After runBlocking")
    }
    suspend fun add(x: Int, y: Int): Int {
        delay(Random.nextLong(1000L))
        return x + y
    }
    suspend fun runAsync() = coroutineScope {
        val firstSum = async {
            println(Thread.currentThread().name)
            add(2, 2)
        }
        val secondSum = async {
            println(Thread.currentThread().name)
            add(3, 4)
        }
        println("Awaiting concurrent sums...")
        val total = firstSum.await() + secondSum.await()
        println("Total is $total")
    }

    suspend fun coroutineScopeMethod() = coroutineScope {
        for (i in 0 until 10) {
            launch {
                delay(1000L - i * 10)
                print("❤$i ")
            }
        }
    }
}