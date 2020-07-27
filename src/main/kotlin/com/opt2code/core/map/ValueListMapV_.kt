/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.map

import com.opt2code.core.obj.Data
import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.PreObjectV
import com.opt2code.core.obj.PreObjectV_

open class ValueListMapV_<S: ObjectV, T: ObjectV> private constructor(
        override val obj: MapV<S, T>,
        data: Data,
        o: PreObjectV = PreObjectV_.preObjectV(data)
): PreObjectV by o, ValueListMapV<S, T> {

    override fun new_(substitute: Boolean): ValueListMapV<S, T> = ValueListMapV_(obj, data_.copy(substitute = substitute))

    companion object {
        fun <S: ObjectV, T: ObjectV> valueListMapV(obj: MapV<S, T>, data: Data = Data.data()): ValueListMapV<S, T> = ValueListMapV_<S, T>(obj, data)
    }
}