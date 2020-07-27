/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.decouple

import com.opt2code.core.decouple.ReV_.Companion.reV
import com.opt2code.core.function.arg.ArgV_.Companion.argV
import com.opt2code.core.function.arg.AsFunctionV_.Companion.asFunctionV
import com.opt2code.core.obj.Data
import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.PreObjectV
import com.opt2code.core.obj.PreObjectV_
import com.opt2code.core.obj.operation

class ReV_<S: ObjectV, T: ObjectV> private constructor(
        private val wrapped: S,
        private val arg: S,
        private val result: T,
        data: Data,
        o: PreObjectV = PreObjectV_.preObjectV(data)
): PreObjectV by o, ReV<S, T> {

    override fun new_(substitute: Boolean): ReV<S, T> = ReV_(wrapped, arg, result, data_.copy(substitute = substitute))

    override fun elements(): List<ObjectV> = arrayListOf(wrapped, asFunctionV(result, arg))

    override fun invoke(): T = result.operation(this)

    override fun wrappedValue(): S = wrapped

    override fun argValue(): S = arg

    companion object {
        fun <S: ObjectV, T: ObjectV> reV(
                source: S,
                s: S,
                data: Data = Data.data(),
                invoke: (S).(S) -> T
        ): ReV<S, T> {
            val arg = argV(s)()
            return ReV_(source, arg, arg.invoke(arg), data)
        }
    }
}

fun <S: ObjectV, T: ObjectV> S.re(
        s: S,
        data: Data = Data.data(),
        invoke: (S).(S) -> T
): T = reV(this, s, data, invoke)()