/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.function.arg

import com.opt2code.core.obj.Data
import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.PreObjectV
import com.opt2code.core.obj.PreObjectV_
import com.opt2code.core.obj.operation

class ArgV_<S: ObjectV> private constructor(
        val arg: S,
        data: Data,
        o: PreObjectV = PreObjectV_.preObjectV(data)
): PreObjectV by o, ArgV<S> {

    override fun new_(substitute: Boolean): ArgV<S> = ArgV_(arg, data_.copy(substitute = substitute))

    override fun elements(): List<ObjectV> = arrayListOf(arg)

    override fun invoke(): S = arg.operation(this)

    companion object {
        fun <S: ObjectV> argV(arg: S, data: Data = Data.data()): ArgV<S> = ArgV_<S>(arg, data)
    }
}

