/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.function.consume.operation

import com.opt2code.core.obj.Data
import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.PreObjectV
import com.opt2code.core.obj.PreObjectV_

open class InvokeConsumerV_<T: ObjectV> private constructor(
        override val value: ObjectV,
        override val arg: T,
        data: Data,
        o: PreObjectV = PreObjectV_.preObjectV(data)
): PreObjectV by o, InvokeConsumerV<T> {


    override fun new_(substitute: Boolean): InvokeConsumerV<T> = InvokeConsumerV_(value, arg, data_.copy(substitute = substitute))

    companion object {
        fun <T: ObjectV> invokeConsumerV(
                value: ObjectV,
                arg: T,
                data: Data = Data.data()
        ): InvokeConsumerV<T> = InvokeConsumerV_(
                value,
                arg,
                data
        )
    }
}

