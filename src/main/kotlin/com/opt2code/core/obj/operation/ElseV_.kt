/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.obj.operation

import com.opt2code.core.obj.Data
import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.PreObjectV
import com.opt2code.core.obj.PreObjectV_

open class ElseV_<T: ObjectV> private constructor(
        override val t: T,
        override val upperCondition: IfV<T>,
        data: Data = Data(), o: PreObjectV = PreObjectV_.preObjectV(data)
): PreObjectV by o, ElseV<T> {

    override fun new_(substitute: Boolean): ElseV<T> = ElseV_(t, upperCondition, data_.copy(substitute = substitute))

    val elements: List<ObjectV> = arrayListOf(upperCondition.addElse_(t))

    override fun elements(): List<ObjectV> = elements

    companion object {
        fun <T: ObjectV> elseV(t: T, upperCondition: IfV<T>): ElseV<T> = ElseV_(t, upperCondition)
    }
}

