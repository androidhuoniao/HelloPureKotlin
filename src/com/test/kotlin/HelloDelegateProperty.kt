package com.test.kotlin

import kotlin.properties.Delegates

class HelloDelegateProperty {
    val lazyValue: String by lazy {
        println("computed!")
        "Hello"
    }

    fun main() {
        println(lazyValue)
        println(lazyValue)
    }
}

class User {
    var name: String by Delegates.observable("<no name>") {
        prop, old, new ->
        println("$old -> $new")
    }
}

fun main() {
    var helloDelegateProperty = HelloDelegateProperty()
    helloDelegateProperty.main()

    val user = User()
    user.name = "first"
    user.name = "second"
}