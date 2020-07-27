/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.error

import com.opt2code.core.obj.Data
import com.opt2code.core.obj.PreObjectV
import com.opt2code.core.obj.PreObjectV_

class ErrorV_ private constructor(
        data: Data,
        o: PreObjectV = PreObjectV_.preObjectV(data)
): PreObjectV by o, ErrorV {

    override fun new_(substitute: Boolean): ErrorV = ErrorV_(data_.copy(substitute = substitute))

    companion object {
        fun errorV_(data: Data = Data.data()): ErrorV = ErrorV_(data)

        fun <T: ErrorV> errorV(data: Data = Data(), error: (ErrorV) -> T): T = error(ErrorV_(data))
    }
}