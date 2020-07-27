/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.date

import com.opt2code.core.obj.Data
import com.opt2code.core.obj.PreObjectV
import com.opt2code.core.obj.PreObjectV_

open class CurrentDateV_ private constructor(
        data: Data,
        o: PreObjectV = PreObjectV_.preObjectV(data)
): PreObjectV by o, CurrentDateV {

    override fun new_(substitute: Boolean): CurrentDateV = CurrentDateV_(data_.copy(substitute = substitute))

    companion object {
        fun currentDateV(data: Data = Data.data()): DateV = CurrentDateV_(data)
    }
}