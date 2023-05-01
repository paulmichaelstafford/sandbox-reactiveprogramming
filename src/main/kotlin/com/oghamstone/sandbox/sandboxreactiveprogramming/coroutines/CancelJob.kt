package com.oghamstone.sandbox.sandboxreactiveprogramming.coroutines

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

class CancelJob {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val t = CancelJob()
            t.main()
        }
    }
    fun main() = runBlocking {
        val job = launch {
            repeat(100) { i ->
                println("job: I'm waiting $i...")
                delay(100L)
            }
        }
        delay(500L)
        println("main: That's enough waiting")
        job.cancel()
        println("main: waiting for jobs to be completed...")
        val time = measureTimeMillis {
            job.join()
        }
        println("main: jobs completed... ${time}ms")
        println("main: Done")
    }
}