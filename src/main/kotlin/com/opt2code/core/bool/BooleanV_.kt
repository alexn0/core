/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.bool

import com.opt2code.core.bool.BooleanV_.Companion.booleanV
import com.opt2code.core.obj.Data
import com.opt2code.core.obj.PreObjectV
import com.opt2code.core.obj.PreObjectV_.Companion.preObjectV

open class BooleanV_ private constructor(data: Data = Data(), o: PreObjectV = preObjectV(data)): PreObjectV by o, BooleanV {

    override fun new_(substitute: Boolean): BooleanV = BooleanV_(data_.copy(substitute = substitute))

    companion object {
        fun booleanV(data: Data = Data()): BooleanV = BooleanV_(data)
    }
}

fun Boolean.V(): BooleanV = booleanV(Data.notNullData(this))

