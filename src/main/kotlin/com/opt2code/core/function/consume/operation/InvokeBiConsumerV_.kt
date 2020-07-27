/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.function.consume.operation

import com.opt2code.core.obj.Data
import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.PreObjectV
import com.opt2code.core.obj.PreObjectV_

open class InvokeBiConsumerV_<S: ObjectV, T: ObjectV> private constructor(
        override val value: ObjectV,
        override val arg1: S,
        override val arg2: T,
        data: Data,
        o: PreObjectV = PreObjectV_.preObjectV(data)
): PreObjectV by o, InvokeBiConsumerV<S, T> {

    override fun new_(substitute: Boolean): InvokeBiConsumerV<S, T> = InvokeBiConsumerV_(value, arg1, arg2, data_.copy(substitute = substitute))

    companion object {
        fun <S: ObjectV, T: ObjectV> invokeBiConsumerV(
                value: ObjectV,
                arg1: S,
                arg2: T,
                data: Data = Data.data()
        ): InvokeBiConsumerV<S, T> = InvokeBiConsumerV_(
                value,
                arg1,
                arg2,
                data
        )
    }
}