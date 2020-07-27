/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.obj.operation

import com.opt2code.core.obj.Data
import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.PreObjectV
import com.opt2code.core.obj.PreObjectV_

open class FinallyV_<T: ObjectV> private constructor(
        override val t: T,
        override val upperCondition: TryV<T>,
        data: Data = Data(), o: PreObjectV = PreObjectV_.preObjectV(data)
): PreObjectV by o, FinallyV<T> {

    override fun new_(substitute: Boolean): FinallyV<T> = FinallyV_(t, upperCondition, data_.copy(substitute = substitute))

    companion object {
        fun <T: ObjectV> finallyV(t: T, upperCondition: TryV<T>): FinallyV<T> = FinallyV_(t, upperCondition)
    }
}