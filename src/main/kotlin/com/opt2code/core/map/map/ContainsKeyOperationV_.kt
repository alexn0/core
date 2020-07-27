/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.map.map

import com.opt2code.core.map.MapV
import com.opt2code.core.obj.Data
import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.PreObjectV
import com.opt2code.core.obj.PreObjectV_

open class ContainsKeyOperationV_<S: ObjectV, T: ObjectV> private constructor(
        override val arg: S,
        override val mapping: MapV<S, T>,
        data: Data,
        o: PreObjectV = PreObjectV_.preObjectV(data)
): PreObjectV by o, ContainsKeyOperationV<S, T> {

    override fun new_(substitute: Boolean): ContainsKeyOperationV<S, T> = ContainsKeyOperationV_(arg, mapping, data_.copy(substitute = substitute))

    companion object {
        fun <S: ObjectV, T: ObjectV> containsKeyOperationV(arg: S, mapping: MapV<S, T>, data: Data = Data.data()): ContainsKeyOperationV<S, T> = ContainsKeyOperationV_<S, T>(arg, mapping, data)
    }
}