/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.function.function.operation

import com.opt2code.core.obj.Data
import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.PreObjectV
import com.opt2code.core.obj.PreObjectV_

open class InvokeBiFunctionV_<S: ObjectV, T: ObjectV, U: ObjectV> private constructor(
        override val value: U,
        override val arg1: S,
        override val arg2: T,
        data: Data,
        o: PreObjectV = PreObjectV_.preObjectV(data)
): PreObjectV by o, InvokeBiFunctionV<S, T, U> {

    override fun new_(substitute: Boolean): InvokeBiFunctionV<S, T, U> = InvokeBiFunctionV_(value, arg1, arg2, data_.copy(substitute = substitute))

    companion object {
        fun <S: ObjectV, T: ObjectV, U: ObjectV> invokeBiFunctionV(
                value: U,
                arg1: S,
                arg2: T,
                data: Data = Data.data()
        ): InvokeBiFunctionV<S, T, U> = InvokeBiFunctionV_(
                value,
                arg1,
                arg2,
                data
        )
    }
}