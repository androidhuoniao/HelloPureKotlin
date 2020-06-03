package com.test.kotlin

fun main() {
    action(1, {
        println("action1 is working")
    })

    var method: () -> Unit = {
        println("method is working")
    }
    action(2, method)

    actionWithArguments(3) { it ->
        println("argument is $it")
        true
    }

    var methodWithArg: (Int) -> Boolean = {
        println("argument is $it")
        true
    }
    actionWithArguments(3) {
        println("argument is $it")
        true
    }

    actionWithArguments(4, methodWithArg)

    println("--------下面是函数做为返回值------------")
    var methodGetSum = getSum()
    var result = methodGetSum.invoke(1, 2)
    println("result is $result")

}

fun action(first: Int, callback: () -> Unit) {
    callback.invoke()
}

fun actionWithArguments(first: Int, callback: (Int) -> Boolean) {
    if (callback(first)) {
        println("callback is true")
    } else {
        println("callback is false")
    }
}

fun getSum(): (Int, Int) -> Int {
    return { i, j ->
        i + j
    }

}