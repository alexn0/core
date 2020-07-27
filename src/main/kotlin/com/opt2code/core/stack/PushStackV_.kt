/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.stack

import com.opt2code.core.obj.Data
import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.PreObjectV
import com.opt2code.core.obj.PreObjectV_

open class PushStackV_<S: ObjectV> private constructor(
        override val arg: S,
        override val obj: StackV<S>,
        data: Data,
        o: PreObjectV = PreObjectV_.preObjectV(data)
): PreObjectV by o, PushStackV<S> {

    override fun new_(substitute: Boolean): PushStackV<S> = PushStackV_(arg, obj, data_.copy(substitute = substitute))

    companion object {
        fun <S: ObjectV> pushStackV(arg: S, obj: StackV<S>, data: Data = Data.data()): PushStackV<S> = PushStackV_<S>(arg, obj, data)
    }
}