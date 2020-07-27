/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.list

import com.opt2code.core.cell.Wl
import com.opt2code.core.cell.Wl.Companion.wl
import com.opt2code.core.obj.Data
import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.PreObjectV
import com.opt2code.core.obj.PreObjectV_

open class ListV_<S: ObjectV> private constructor(
        override val common: Wl<S>,
        data: Data,
        o: PreObjectV = PreObjectV_.preObjectV(data)
): PreObjectV by o, ListV<S> {

    override fun new_(substitute: Boolean): ListV<S> = ListV_(common, data_.copy(substitute = substitute))

    override fun <K: ObjectV> new(common: () -> K): ListV<K> = listV(common = common)

    companion object {
        fun <S: ObjectV> listV(data: Data = Data.data(), common: () -> S): ListV<S> = ListV_<S>(wl(common), data)
    }
}