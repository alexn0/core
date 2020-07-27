/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.number.number

import com.opt2code.core.number.NumberV
import com.opt2code.core.obj.Data
import com.opt2code.core.obj.PreObjectV
import com.opt2code.core.obj.PreObjectV_

open class RemNumberV_ private constructor(override val first: NumberV,
                                           override val second: NumberV,
                                           data: Data = Data(), o: PreObjectV = PreObjectV_.preObjectV(data)
): PreObjectV by o, RemNumberV {

    override fun new_(substitute: Boolean): RemNumberV = RemNumberV_(first, second, data_.copy(substitute = substitute))

    companion object {
        fun remNumberV(first: NumberV, second: NumberV): RemNumberV = RemNumberV_(first, second)
    }

}