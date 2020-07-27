/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.map.pair

import com.opt2code.core.cell.CellV
import com.opt2code.core.cell.CellV_.Companion.cellV
import com.opt2code.core.obj.Data
import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.PreObjectV
import com.opt2code.core.obj.PreObjectV_.Companion.preObjectV

class PairV_<S: ObjectV, T: ObjectV> private constructor(
        override val key: CellV<S>,
        override val value: CellV<T>,
        private val preObjectV: PreObjectV
): PreObjectV by preObjectV, PairV<S, T> {

    override fun elements(): List<ObjectV> = arrayListOf(key, value)

    override fun new_(substitute: Boolean): PairV<S, T> = PairV_(key, value, preObjectV(data_.copy(substitute = substitute)))

    companion object {
        fun <S: ObjectV, T: ObjectV> pairV(key: S, value: T, data: Data = Data()): PairV<S, T> =
                PairV_(cellV(key), cellV(value), preObjectV(data))

    }
}