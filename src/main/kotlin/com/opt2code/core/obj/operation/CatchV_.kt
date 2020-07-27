/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.obj.operation

import com.opt2code.core.error.ErrorV
import com.opt2code.core.obj.Data
import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.PreObjectV
import com.opt2code.core.obj.PreObjectV_

open class CatchV_<T: ObjectV> private constructor(
        override val error: ErrorV,
        override val t: T,
        override val upperCondition: TryV<T>,
        data: Data = Data(), o: PreObjectV = PreObjectV_.preObjectV(data)
): PreObjectV by o, CatchV<T> {

    override fun new_(substitute: Boolean): CatchV<T> = CatchV_(error, t, upperCondition, data_.copy(substitute = substitute))

    override fun vCatch(error: ErrorV, block: () -> T): CatchV<T> = catchV(error, block(), this)

    override fun vFinally(block: () -> T): FinallyV<T> = FinallyV_.finallyV(block(), this)

    companion object {
        fun <T: ObjectV> catchV(error: ErrorV, t: T, upperCondition: TryV<T>): CatchV<T> = CatchV_(error, t, upperCondition)
    }

}