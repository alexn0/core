/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.cell

import com.opt2code.core.Closure
import com.opt2code.core.cell.GetterV_.Companion.getterV
import com.opt2code.core.cell.UpdateV_.Companion.updateV
import com.opt2code.core.obj.Data
import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.PreObjectV
import com.opt2code.core.obj.PreObjectV_.Companion.preObjectV
import com.opt2code.core.obj.new
import com.opt2code.core.obj.operation

class PreCellV_<T: ObjectV> private constructor(
        o: PreObjectV,
        private var t: T,
        private val closure: Closure<CellV<T>>,
        override val t_: ObjectV = t,
        override var parent: ObjectV? = null,
        private val toGetterV: (CellV<T>) -> GetterV<T>,
        private val toUpdateV: (T, CellV<T>) -> UpdateV<T>
): PreCellV<T>, PreObjectV by o {

    override fun invoke(): T {
        return t.new(substitute = true).operation(toGetterV(closure()))
    }

    override fun getFieldClass(): Class<T> = t.getInterfaceClass() as Class<T>

    override fun update(t: T): T = this.t.new(substitute = true).operation(toUpdateV(t, closure()))

    companion object {
        fun <T: ObjectV> preCellV(
                t: T,
                closure: Closure<CellV<T>> = Closure(),
                data: Data = Data(),
                toGetterV: (CellV<T>) -> GetterV<T> = { getterV(it) },
                toUpdateV: (T, CellV<T>) -> UpdateV<T> = { t, cellV -> updateV(t, cellV) }
        ): PreCellV<T> = PreCellV_(preObjectV(data), t, closure, toGetterV = toGetterV, toUpdateV = toUpdateV)
    }

    override fun dataObj(): Data = t.data_

}