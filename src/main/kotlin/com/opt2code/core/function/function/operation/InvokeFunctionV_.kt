/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.function.function.operation

import com.opt2code.core.obj.Data
import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.PreObjectV
import com.opt2code.core.obj.PreObjectV_

open class InvokeFunctionV_<S: ObjectV, T: ObjectV> private constructor(
        override val value: T,
        override val arg: S,
        data: Data,
        o: PreObjectV = PreObjectV_.preObjectV(data)
): PreObjectV by o, InvokeFunctionV<S, T> {

    override fun new_(substitute: Boolean): InvokeFunctionV<S, T> = InvokeFunctionV_(value, arg, data_.copy(substitute = substitute))

    companion object {
        fun <S: ObjectV, T: ObjectV> invokeFunctionV(
                value: T,
                arg: S,
                data: Data = Data.data()
        ): InvokeFunctionV<S, T> = InvokeFunctionV_(
                value,
                arg,
                data
        )
    }
}

