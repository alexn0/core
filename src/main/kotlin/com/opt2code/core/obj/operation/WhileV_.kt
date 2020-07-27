/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.obj.operation

import com.opt2code.core.bool.BooleanV
import com.opt2code.core.obj.Data
import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.PreObjectV
import com.opt2code.core.obj.PreObjectV_

open class WhileV_<T: ObjectV> private constructor(
        override val condition: BooleanV,
        override val t: T,
        data: Data = Data(), o: PreObjectV = PreObjectV_.preObjectV(data)
): PreObjectV by o, WhileV<T> {

    override fun new_(substitute: Boolean): WhileV<T> = WhileV_(condition, t, data_.copy(substitute = substitute))

    companion object {
        fun <T: ObjectV> whileV(condition: BooleanV, t: T): WhileV<T> = WhileV_(condition, t)
    }
}