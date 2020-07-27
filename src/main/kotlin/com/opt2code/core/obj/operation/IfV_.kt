/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.obj.operation

import com.opt2code.core.bool.BooleanV
import com.opt2code.core.function.arg.AsFunctionV_.Companion.asFunctionV
import com.opt2code.core.obj.Data
import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.PreObjectV
import com.opt2code.core.obj.PreObjectV_.Companion.preObjectV
import com.opt2code.core.obj.operation.ElseIfV_.Companion.elseIfV
import com.opt2code.core.obj.operation.ElseV_.Companion.elseV

open class IfV_<T: ObjectV> private constructor(
        override val condition: BooleanV,
        override val t: T,
        data: Data = Data(), o: PreObjectV = preObjectV(data)
): PreObjectV by o, IfV<T> {

    override fun new_(substitute: Boolean): IfV<T> = IfV_(condition, t, data_.copy(substitute = substitute))

    val elements_ = arrayListOf(asFunctionV(condition), asFunctionV(t))

    override fun elements(): List<ObjectV> = elements_

    override fun vElseIf(condition: BooleanV, block: () -> T): ElseIfV<T> = elseIfV(condition, block(), this)

    override fun vElse(block: () -> T): ElseV<T> = elseV(block(), this)

    companion object {
        fun <T: ObjectV> ifV(condition: BooleanV, value: T): IfV<T> = IfV_(condition, value)
    }
}