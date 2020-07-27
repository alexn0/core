/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.enum

import com.opt2code.core.obj.Data
import com.opt2code.core.obj.PreObjectV
import com.opt2code.core.obj.PreObjectV_

open class EnumV_<T: Enum<T>> private constructor(
        override val enumClass: Class<T>,
        data: Data,
        o: PreObjectV = PreObjectV_.preObjectV(data)
): PreObjectV by o, EnumV<T> {

    override fun new_(substitute: Boolean): EnumV<T> = EnumV_(enumClass, data_.copy(substitute = substitute))

    companion object {
        fun <T: Enum<T>> enumV(enumClass: Class<T>, data: Data = Data.data()): EnumV<T> = EnumV_(enumClass, data)

        fun <T: Enum<T>> enumV(enum: T, data: Data = Data.data()): EnumV<T> = enumV(enum.declaringClass, Data(fixedValue = enum))
    }
}