/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.cell

import com.opt2code.core.obj.Data
import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.PreObjectV
import com.opt2code.core.obj.PreObjectV_

class UpdateV_<T: ObjectV>(
        override val value: T,
        val cellV: CellV<T>,
        data: Data = Data(), o: PreObjectV = PreObjectV_.preObjectV(data)
): UpdateV<T>, PreObjectV by o {

    override fun new_(substitute: Boolean): UpdateV<T> = UpdateV_(value, cellV, data_.copy(substitute = substitute))

    override fun elements(): List<ObjectV> = arrayListOf(cellV, value)

    companion object {
        fun <T: ObjectV> updateV(value: T, cellV: CellV<T>): UpdateV<T> = UpdateV_(value, cellV)
    }
}