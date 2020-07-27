/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.function.function.operation

import com.opt2code.core.obj.Data
import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.PreObjectV
import com.opt2code.core.obj.PreObjectV_

class ReplaceArgForInvokeFunctionV_<S: ObjectV, T: ObjectV> private constructor(
        override val value: T,
        override val newArg: S,
        override val oldArg: S,
        data: Data,
        o: PreObjectV = PreObjectV_.preObjectV(data)
): PreObjectV by o, ReplaceArgForInvokeFunctionV<S, T> {

    override fun new_(substitute: Boolean): ReplaceArgForInvokeFunctionV<S, T> = ReplaceArgForInvokeFunctionV_(value, newArg, oldArg, data_.copy(substitute = substitute))

    companion object {
        fun <S: ObjectV, T: ObjectV> replaceArgForInvokeFunctionV(
                value: T,
                newArg: S,
                oldArg: S,
                data: Data = Data.data()
        ): ReplaceArgForInvokeFunctionV<S, T> = ReplaceArgForInvokeFunctionV_<S, T>(value, newArg, oldArg, data)
    }
}