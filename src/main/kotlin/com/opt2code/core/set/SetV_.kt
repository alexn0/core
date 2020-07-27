/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.set

import com.opt2code.core.cell.Wl
import com.opt2code.core.cell.Wl.Companion.wl
import com.opt2code.core.obj.Data
import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.PreObjectV
import com.opt2code.core.obj.PreObjectV_

open class SetV_<S: ObjectV> private constructor(
        override val common: Wl<S>,
        val data: Data,
        o: PreObjectV = PreObjectV_.preObjectV(data)
): PreObjectV by o, SetV<S> {

    override fun new_(substitute: Boolean): SetV<S> = SetV_(common, data_.copy(substitute = substitute))

    override fun <K: ObjectV> new(common: () -> K) = setV(common, data)

    companion object {
        fun <S: ObjectV> setV(common: () -> S, data: Data = Data.data()): SetV<S> = SetV_<S>(wl(common), data)
    }
}