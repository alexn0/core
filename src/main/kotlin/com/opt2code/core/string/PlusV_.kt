/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.string

import com.opt2code.core.obj.Data
import com.opt2code.core.obj.PreObjectV
import com.opt2code.core.obj.PreObjectV_

open class PlusV_ private constructor(
        override val arg1: StringV,
        override val arg2: StringV,
        data: Data,
        o: PreObjectV = PreObjectV_.preObjectV(data)
): PreObjectV by o, PlusV {

    override fun new_(substitute: Boolean): PlusV = PlusV_(arg1, arg2, data_.copy(substitute = substitute))

    companion object {
        fun plusV(arg1: StringV, arg2: StringV, data: Data = Data.data()): PlusV = PlusV_(arg1, arg2, data)
    }
}