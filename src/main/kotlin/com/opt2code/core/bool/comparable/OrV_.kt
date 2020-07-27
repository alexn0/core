/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.bool.comparable

import com.opt2code.core.obj.Data
import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.PreObjectV
import com.opt2code.core.obj.PreObjectV_

open class OrV_(
        override val first: ObjectV,
        override val second: ObjectV,
        data: Data = Data(), o: PreObjectV = PreObjectV_.preObjectV(data)
): PreObjectV by o, OrV {

    override fun new_(substitute: Boolean): OrV = OrV_(first, second, data_.copy(substitute = substitute))

    companion object {
        fun orV(first: ObjectV, second: ObjectV): OrV = OrV_(first, second)
    }

}