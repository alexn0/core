/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.obj.operation

import com.opt2code.core.bool.BooleanV
import com.opt2code.core.function.arg.AsFunctionV_
import com.opt2code.core.obj.Data
import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.PreObjectV
import com.opt2code.core.obj.PreObjectV_

open class IfElseV_<T: ObjectV> private constructor(
        override val condition: BooleanV,
        override val t: T,
        override val s: ObjectV,
        data: Data = Data(), o: PreObjectV = PreObjectV_.preObjectV(data)
): PreObjectV by o, IfElseV<T> {

    override fun new_(substitute: Boolean): IfElseV<T> = IfElseV_(condition, t, s, data_.copy(substitute = substitute))

    val elements: List<ObjectV> = arrayListOf(AsFunctionV_.asFunctionV(condition), AsFunctionV_.asFunctionV(t), AsFunctionV_.asFunctionV(s))

    override fun elements(): List<ObjectV> = elements

    companion object {
        fun <T: ObjectV> ifElseV(condition: BooleanV, t: T, s: ObjectV): IfElseV<T> = IfElseV_(condition, t, s)
    }
}