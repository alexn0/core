/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.stack

import com.opt2code.core.cell.Wl
import com.opt2code.core.obj.Data
import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.PreObjectV
import com.opt2code.core.obj.PreObjectV_

open class StackV_<S: ObjectV> private constructor(
        override val common: Wl<S>,
        data: Data,
        o: PreObjectV = PreObjectV_.preObjectV(data)
): PreObjectV by o, StackV<S> {

    override fun new_(substitute: Boolean): StackV<S> = StackV_(common, data_.copy(substitute = substitute))

    override fun <K: ObjectV> new(common: () -> K): StackV<K> = stackV(common)

    companion object {
        fun <S: ObjectV> stackV(common: () -> S, data: Data = Data.data()): StackV<S> = StackV_<S>(Wl.wl(common), data)
    }
}