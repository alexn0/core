/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.number.number

import com.opt2code.core.number.NumberV
import com.opt2code.core.obj.Data
import com.opt2code.core.obj.PreObjectV
import com.opt2code.core.obj.PreObjectV_

open class PlusNumberV_ private constructor(override val first: NumberV,
                                            override val second: NumberV,
                                            data: Data = Data(), o: PreObjectV = PreObjectV_.preObjectV(data)): PreObjectV by o, PlusNumberV {

    override fun new_(substitute: Boolean): PlusNumberV = PlusNumberV_(first, second, data_.copy(substitute = substitute))

    companion object {
        fun plusNumberV(first: NumberV, second: NumberV): PlusNumberV = PlusNumberV_(first, second)
    }

}