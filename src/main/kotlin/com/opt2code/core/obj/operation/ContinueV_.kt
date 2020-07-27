/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.obj.operation

import com.opt2code.core.obj.Data
import com.opt2code.core.obj.PreObjectV
import com.opt2code.core.obj.PreObjectV_

open class ContinueV_ private constructor(
        data: Data,
        o: PreObjectV = PreObjectV_.preObjectV(data)
): PreObjectV by o, ContinueV {

    override fun new_(substitute: Boolean): ContinueV = ContinueV_(data_.copy(substitute = substitute))

    companion object {
        fun continueV(data: Data = Data.data()): ContinueV = ContinueV_(data)
    }
}