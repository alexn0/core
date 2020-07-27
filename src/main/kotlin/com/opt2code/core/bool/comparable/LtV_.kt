/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.bool.comparable

import com.opt2code.core.obj.ComparableV
import com.opt2code.core.obj.Data
import com.opt2code.core.obj.PreObjectV
import com.opt2code.core.obj.PreObjectV_

class LtV_<T: ComparableV>(
        override val first: T,
        override val second: T,
        data: Data = Data(), o: PreObjectV = PreObjectV_.preObjectV(data)
): PreObjectV by o, LtV<T> {

    override fun new_(substitute: Boolean): LtV<T> = LtV_(first, second, data_.copy(substitute = substitute))

    companion object {
        fun <T: ComparableV> ltV(first: T, second: T): LtV<T> = LtV_(first, second)
    }

}