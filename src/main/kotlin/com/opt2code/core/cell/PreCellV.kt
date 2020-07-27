/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.cell


import com.opt2code.core.obj.Data
import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.PreObjectV

interface PreCellV<T: ObjectV>: PreCellObjectV<T>, PreObjectV


interface PreCellObjectV<T: ObjectV> {
    var parent: ObjectV?

    val t_: ObjectV

    infix fun up(t: T) = update(t)

    fun dataObj(): Data

    operator fun invoke(): T

    fun getFieldClass(): Class<T>

    fun update(t: T): T

    fun update(t: CellV<T>): T = update(t())
}