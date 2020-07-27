/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.obj.operation

import com.opt2code.core.obj.Data
import com.opt2code.core.obj.PreObjectV
import com.opt2code.core.obj.PreObjectV_

open class BreakV_ private constructor(
        data: Data,
        o: PreObjectV = PreObjectV_.preObjectV(data)
): PreObjectV by o, BreakV {

    override fun new_(substitute: Boolean): BreakV = BreakV_(data_.copy(substitute = substitute))

    companion object {
        fun breakV(data: Data = Data.data()): BreakV = BreakV_(data)
    }
}