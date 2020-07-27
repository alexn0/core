/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.map

import com.opt2code.core.cell.Wl
import com.opt2code.core.cell.Wl.Companion.wl
import com.opt2code.core.obj.Data
import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.PreObjectV
import com.opt2code.core.obj.PreObjectV_

class MapV_<S: ObjectV, T: ObjectV> private constructor(
        override val commonArg: Wl<S>,
        override val commonResult: Wl<T>,
        val data: Data = Data(),
        o: PreObjectV = PreObjectV_.preObjectV(data)): PreObjectV by o, MapV<S, T> {

    override fun new_(substitute: Boolean): MapV<S, T> = MapV_(commonArg, commonResult, data_.copy(substitute = substitute))

    override fun <K: ObjectV, L: ObjectV> new(commonArg: () -> K, commonResult: () -> L): MapV<K, L> =
            mapV(commonArg, commonResult, data)

    companion object {
        fun <S: ObjectV, T: ObjectV> mapV(commonArg: () -> S,
                                            commonResult: () -> T,
                                            data: Data = Data()): MapV<S, T> = MapV_(wl(commonArg), wl(commonResult), data)
    }
}