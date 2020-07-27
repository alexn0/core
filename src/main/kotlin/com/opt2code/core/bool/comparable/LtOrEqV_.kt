/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.bool.comparable

import com.opt2code.core.obj.ComparableV
import com.opt2code.core.obj.Data
import com.opt2code.core.obj.PreObjectV
import com.opt2code.core.obj.PreObjectV_

open class LtOrEqV_<T: ComparableV> private constructor(
        override val first: T,
        override val second: T,
        data: Data = Data(), o: PreObjectV = PreObjectV_.preObjectV(data)
): PreObjectV by o, LtOrEqV<T> {

    override fun new_(substitute: Boolean): LtOrEqV<T> = LtOrEqV_(first, second, data_.copy(substitute = substitute))

    companion object {
        fun <T: ComparableV> ltOrEqV(first: T, second: T): LtOrEqV<T> = LtOrEqV_(first, second)
    }
}