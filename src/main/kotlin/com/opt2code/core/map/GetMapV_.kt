/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.map

import com.opt2code.core.obj.Data
import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.PreObjectV
import com.opt2code.core.obj.PreObjectV_

open class GetMapV_<S: ObjectV, T: ObjectV> private constructor(
        override val arg: S,
        override val obj: MapV<S, T>,
        data: Data,
        o: PreObjectV = PreObjectV_.preObjectV(data)
): PreObjectV by o, GetMapV<S, T> {

    override fun new_(substitute: Boolean): GetMapV<S, T> = GetMapV_(arg, obj, data_.copy(substitute = substitute))

    companion object {
        fun <S: ObjectV, T: ObjectV> getMapV(arg: S, obj: MapV<S, T>, data: Data = Data.data()): GetMapV<S, T> = GetMapV_<S, T>(arg, obj, data)
    }
}