/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.function.consume

import com.opt2code.core.function.arg.ArgV_.Companion.argV
import com.opt2code.core.function.consume.operation.InvokeConsumerV
import com.opt2code.core.function.consume.operation.InvokeConsumerV_
import com.opt2code.core.obj.Data
import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.PreObjectV
import com.opt2code.core.obj.PreObjectV_

class ConsumerV_<T: ObjectV> private constructor(
        override val mapping: (T) -> ObjectV,
        data: Data,
        o: PreObjectV = PreObjectV_.preObjectV(data)
): PreObjectV by o, ConsumerV<T> {


    override operator fun invoke(t: T): T = argV(t)().also {
        addOperation(
                InvokeConsumerV_.invokeConsumerV(
                        value = mapping(it),
                        arg = it
                )
        )
    }

    override fun invokeOperation(t: T): InvokeConsumerV<T> = argV(t)().let {
        InvokeConsumerV_.invokeConsumerV(
                value = mapping(it),
                arg = it
        )
    }

    companion object {
        fun <T: ObjectV> consumerV(
                data: Data = Data(),
                mapping: (T) -> ObjectV
        ): ConsumerV<T> = ConsumerV_(mapping, data)
    }

}