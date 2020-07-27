/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.async

import com.opt2code.core.obj.Data
import com.opt2code.core.obj.PreObjectV
import com.opt2code.core.obj.PreObjectV_

open class AsyncV_ private constructor(
        data: Data,
        o: PreObjectV = PreObjectV_.preObjectV(data)
): PreObjectV by o, AsyncV {

    override fun new_(substitute: Boolean): AsyncV = AsyncV_(data_.copy(substitute = substitute))

    companion object {
        fun asyncV(data: Data = Data.data()): AsyncV = AsyncV_(data)
    }
}