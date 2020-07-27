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

open class PutAllOperationV_<S: ObjectV, T: ObjectV> private constructor(
        override val arg: MapV<S, T>,
        data: Data,
        o: PreObjectV = PreObjectV_.preObjectV(data)
): PreObjectV by o, PutAllOperationV<S, T> {

    override fun new_(substitute: Boolean): PutAllOperationV<S, T> = PutAllOperationV_(arg, data_.copy(substitute = substitute))

    companion object {
        fun <S: ObjectV, T: ObjectV> putAllOperationV(arg: MapV<S, T>, data: Data = Data.data()): PutAllOperationV<S, T> = PutAllOperationV_<S, T>(arg, data)
    }
}