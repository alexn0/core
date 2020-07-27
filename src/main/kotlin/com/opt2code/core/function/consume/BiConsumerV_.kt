/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.function.consume

import com.opt2code.core.function.arg.ArgV_
import com.opt2code.core.function.consume.operation.InvokeBiConsumerV
import com.opt2code.core.function.consume.operation.InvokeBiConsumerV_
import com.opt2code.core.obj.Data
import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.PreObjectV
import com.opt2code.core.obj.PreObjectV_
import com.opt2code.core.obj.operation

class BiConsumerV_<S: ObjectV, T: ObjectV> private constructor(
        override val mapping: (S, T) -> ObjectV,
        data: Data,
        o: PreObjectV = PreObjectV_.preObjectV(data)
): PreObjectV by o, BiConsumerV<S, T> {


    override operator fun invoke(s: S, t: T): S {
        val s1 = (ArgV_.argV(s))()
        val s2 = (ArgV_.argV(t))()
        val invoke = InvokeBiConsumerV_.invokeBiConsumerV(
                value = mapping(s, t),
                arg1 = s1,
                arg2 = s2
        )
        return s1.operation(invoke)
    }

    override fun invokeOperation(s: S, t: T): InvokeBiConsumerV<S, T> {
        val s1 = (ArgV_.argV(s))()
        val s2 = (ArgV_.argV(t))()
        return InvokeBiConsumerV_.invokeBiConsumerV(
                value = mapping(s, t),
                arg1 = s1,
                arg2 = s2
        )
    }

    companion object {
        fun <S: ObjectV, T: ObjectV> biConsumerV(
                data: Data = Data(),
                mapping: (S, T) -> ObjectV
        ): BiConsumerV<S, T> = BiConsumerV_(mapping, data)
    }
}