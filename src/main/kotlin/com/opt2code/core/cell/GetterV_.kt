/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.cell

import com.opt2code.core.obj.Data
import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.PreObjectV
import com.opt2code.core.obj.PreObjectV_

class GetterV_<T: ObjectV> private constructor(
        val cellV: CellV<T>,
        data: Data = Data(), o: PreObjectV = PreObjectV_.preObjectV(data)
): GetterV<T>, PreObjectV by o {

    override fun new_(substitute: Boolean): GetterV<T> = GetterV_(cellV, data_.copy(substitute = substitute))

    override fun elements(): List<ObjectV> = arrayListOf(cellV)

    companion object {
        fun <T: ObjectV> getterV(cellV: CellV<T>): GetterV<T> = GetterV_(cellV)
    }
}