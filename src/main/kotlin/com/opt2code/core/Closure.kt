/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core

class Closure<T: Any>() {
    lateinit var t: T

    val get: () -> T = { t }

    operator fun invoke(): T = get()
}