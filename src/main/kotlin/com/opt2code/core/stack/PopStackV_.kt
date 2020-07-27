/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.stack

import com.opt2code.core.obj.Data
import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.PreObjectV
import com.opt2code.core.obj.PreObjectV_

open class PopStackV_<S: ObjectV> private constructor(
        override val obj: StackV<S>,
        data: Data,
        o: PreObjectV = PreObjectV_.preObjectV(data)
): PreObjectV by o, PopStackV<S> {

    override fun new_(substitute: Boolean): PopStackV<S> = PopStackV_(obj, data_.copy(substitute = substitute))

    companion object {
        fun <S: ObjectV> popStackV(obj: StackV<S>, data: Data = Data.data()): PopStackV<S> = PopStackV_<S>(obj, data)
    }
}