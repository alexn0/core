/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.cell

import com.opt2code.core.Closure
import com.opt2code.core.cell.PreCellV_.Companion.preCellV
import com.opt2code.core.env.CoreEnvironment
import com.opt2code.core.env.getInitedConfig
import com.opt2code.core.obj.Data
import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.new___

class CellV_<T: ObjectV> private constructor(o: PreCellV<T>,
                                              private val t: T): CellV<T>, PreCellV<T> by o {

    override fun new_(substitute: Boolean): CellV<T> = cellV(t.new___(substitute), data = data_.copy(substitute = substitute))

    companion object {
        fun <T: ObjectV> cellV(
                t: T,
                closure: Closure<CellV<T>> = Closure(),
                data: Data = Data(),
                toGetterV: (CellV<T>) -> GetterV<T> = { GetterV_.getterV(it) },
                toUpdateV: (T, CellV<T>) -> UpdateV<T> = { t, cellV -> UpdateV_.updateV(t, cellV) }
        ): CellV<T> = CellV_(preCellV(t, closure, data, toGetterV = toGetterV, toUpdateV = toUpdateV), t)
                .also { closure.t = it }.let { getInitedConfig().env<CoreEnvironment>().initCell(it) }
    }

}