/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.number.number

import com.opt2code.core.number.NumberV
import com.opt2code.core.obj.Data
import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.PreObjectV
import com.opt2code.core.obj.PreObjectV_

open class DivNumberV_ private constructor(
        override val first: NumberV,
        override val second: NumberV,
        data: Data = Data(), o: PreObjectV = PreObjectV_.preObjectV(data)
): PreObjectV by o, DivNumberV {

    override fun new_(substitute: Boolean): DivNumberV = DivNumberV_(first, second, data_.copy(substitute = substitute))

    override fun elements(): List<ObjectV> = arrayListOf(first, second)

    companion object {
        fun divNumberV(first: NumberV, second: NumberV): DivNumberV = DivNumberV_(first, second)
    }

}