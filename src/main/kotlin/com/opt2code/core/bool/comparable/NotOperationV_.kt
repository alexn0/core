/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.bool.comparable

import com.opt2code.core.bool.BooleanV
import com.opt2code.core.obj.Data
import com.opt2code.core.obj.PreObjectV
import com.opt2code.core.obj.PreObjectV_

open class NotOperationV_ private constructor(
        override val v: BooleanV,
        data: Data,
        o: PreObjectV = PreObjectV_.preObjectV(data)
): PreObjectV by o, NotOperationV {

    override fun new_(substitute: Boolean): NotOperationV = NotOperationV_(v, data_.copy(substitute = substitute))

    companion object {
        fun notOperationV(v: BooleanV, data: Data = Data.data()): NotOperationV = NotOperationV_(v, data)
    }
}