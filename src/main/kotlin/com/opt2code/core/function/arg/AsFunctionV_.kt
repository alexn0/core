/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.function.arg

import com.opt2code.core.obj.Data
import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.PreObjectV
import com.opt2code.core.obj.PreObjectV_

class AsFunctionV_<S: ObjectV> private constructor(
        val func: S,
        vararg var args: ObjectV,
        data: Data,
        o: PreObjectV = PreObjectV_.preObjectV(data)
): PreObjectV by o, AsFunctionV<S> {

    override fun new_(substitute: Boolean): AsFunctionV<S> = AsFunctionV_(func, *args, data = data_.copy(substitute = substitute))

    override fun hiddenElements(): List<ObjectV> = arrayListOf(*args)

    override fun hiddenMainElement(): ObjectV = func

    companion object {
        fun <S: ObjectV> asFunctionV(func: S, vararg args: ObjectV, data: Data = Data.data()): AsFunctionV<S> = AsFunctionV_(func, args = *args, data = data)
    }
}