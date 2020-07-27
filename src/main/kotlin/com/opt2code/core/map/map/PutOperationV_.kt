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

open class PutOperationV_<S: ObjectV, T: ObjectV> private constructor(
        override val key: S,
        override val value: T,
        override val mapping: MapV<S, T>,
        data: Data,
        o: PreObjectV = PreObjectV_.preObjectV(data)
): PreObjectV by o, PutOperationV<S, T> {

    override fun new_(substitute: Boolean): PutOperationV<S, T> = PutOperationV_(key, value, mapping, data_.copy(substitute = substitute))

    companion object {
        fun <S: ObjectV, T: ObjectV> putOperationV(key: S, value: T, mapping: MapV<S, T>, data: Data = Data.data()): PutOperationV<S, T> = PutOperationV_<S, T>(key, value, mapping, data)
    }
}