/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.obj

open class NextV_<S: ObjectV, T: ObjectV> private constructor(
        override val s: S,
        override val t: T,
        data: Data,
        o: PreObjectV = PreObjectV_.preObjectV(data)
): PreObjectV by o, NextV<S, T> {

    override fun new_(substitute: Boolean): NextV<S, T> = NextV_(s, t, data_.copy(substitute = substitute))

    companion object {
        fun <S: ObjectV, T: ObjectV> nextV(s: S, t: T, data: Data = Data.data(ordering = true)): NextV<S, T> = NextV_<S, T>(s, t, data)
    }
}