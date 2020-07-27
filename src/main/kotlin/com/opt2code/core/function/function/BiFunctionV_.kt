/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.function.function

import com.opt2code.core.function.function.operation.InvokeBiFunctionV
import com.opt2code.core.function.function.operation.InvokeBiFunctionV_
import com.opt2code.core.obj.Data
import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.PreObjectV
import com.opt2code.core.obj.PreObjectV_
import com.opt2code.core.obj.new

class BiFunctionV_<S: ObjectV, T: ObjectV, U: ObjectV> private constructor(
        override val mapping: (S, T) -> U,
        data: Data,
        o: PreObjectV = PreObjectV_.preObjectV(data)
): PreObjectV by o, BiFunctionV<S, T, U> {


    override operator fun invoke(s: S, t: T): U {
        return mapping(s, t).new(substitute = true).apply {
            addOperation(InvokeBiFunctionV_.invokeBiFunctionV(value = mapping(s, t), arg1 = s, arg2 = t))
        }

    }

    override fun invokeOperation(s: S, t: T): InvokeBiFunctionV<S, T, U> {
        return InvokeBiFunctionV_.invokeBiFunctionV(
                value = mapping(s, t),
                arg1 = s,
                arg2 = t
        )
    }


    companion object {
        fun <S: ObjectV, T: ObjectV, U: ObjectV> biFunctionV(
                data: Data = Data(),
                mapping: (S, T) -> U
        ): BiFunctionV<S, T, U> = BiFunctionV_(mapping, data)
    }

}