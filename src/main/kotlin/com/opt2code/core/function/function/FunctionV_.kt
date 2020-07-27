/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.function.function

import com.opt2code.core.function.function.operation.InvokeFunctionV
import com.opt2code.core.function.function.operation.InvokeFunctionV_.Companion.invokeFunctionV
import com.opt2code.core.obj.Data
import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.PreObjectV
import com.opt2code.core.obj.PreObjectV_
import com.opt2code.core.obj.new

class FunctionV_<S: ObjectV, T: ObjectV> private constructor(
        override val mapping: (S) -> T,
        data: Data,
        o: PreObjectV = PreObjectV_.preObjectV(data)
): PreObjectV by o, FunctionV<S, T> {


    override operator fun invoke(t: S): T = mapping(t).new().apply {
        addOperation(invokeFunctionV(value = mapping(t), arg = t))
    }

    override fun invokeOperation(t: S): InvokeFunctionV<S, T> = invokeFunctionV(value = mapping(t), arg = t)

    companion object {
        fun <S: ObjectV, T: ObjectV> functionV(
                data: Data = Data(),
                mapping: (S) -> T
        ): FunctionV<S, T> = FunctionV_(mapping, data)
    }

}