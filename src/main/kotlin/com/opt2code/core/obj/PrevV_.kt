/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.obj

open class PrevV_<S: ObjectV, T: ObjectV> private constructor(
        override val s: S,
        override val t: T,
        data: Data,
        o: PreObjectV = PreObjectV_.preObjectV(data)
): PreObjectV by o, PrevV<S, T> {

    override fun new_(substitute: Boolean): PrevV<S, T> = PrevV_(s, t, data_.copy(substitute = substitute))

    override fun elements(): List<ObjectV> {
        return arrayListOf(s, t)
    }

    companion object {
        fun <S: ObjectV, T: ObjectV> prevV(s: S, t: T, data: Data = Data.data(ordering = true)): PrevV<S, T> = PrevV_<S, T>(s, t, data)
    }
}