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

open class TryV_<T: ObjectV> private constructor(
        override val t: T,
        data: Data = Data(), o: PreObjectV = PreObjectV_.preObjectV(data)
): PreObjectV by o, TryV<T> {

    override fun new_(substitute: Boolean): TryV<T> = TryV_(t, data_.copy(substitute = substitute))

    override fun vCatch(error: ErrorV, block: () -> T): CatchV<T> = CatchV_.catchV(error, block(), this)

    override fun vFinally(block: () -> T): FinallyV<T> = FinallyV_.finallyV(block(), this)

    companion object {
        fun <T: ObjectV> tryV(value: T): TryV<T> = TryV_(value)
    }
}