/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.function.arg

import com.opt2code.core.obj.Data
import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.PreObjectV
import com.opt2code.core.obj.PreObjectV_

class AsArgReplacementV_ private constructor(
        override val hiddenElement: ObjectV,
        override val isUse: Boolean,
        data: Data,
        o: PreObjectV = PreObjectV_.preObjectV(data)
): PreObjectV by o, AsArgReplacementV {

    override fun new_(substitute: Boolean): AsArgReplacementV = AsArgReplacementV_(hiddenElement, isUse, data_.copy(substitute = substitute))

    companion object {
        fun asArgReplacementV(asFunc: ObjectV, isUse: Boolean = true, data: Data = Data.data()): AsArgReplacementV = AsArgReplacementV_(asFunc, isUse, data = data)
    }
}