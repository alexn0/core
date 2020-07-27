/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.obj.operation

import com.opt2code.core.bool.BooleanV
import com.opt2code.core.obj.Data
import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.PreObjectV
import com.opt2code.core.obj.PreObjectV_.Companion.preObjectV
import com.opt2code.core.obj.operation.ElseV_.Companion.elseV
import com.opt2code.core.obj.operation.IfV_.Companion.ifV

open class ElseIfV_<T: ObjectV> private constructor(
        override val condition: BooleanV,
        override val t: T,
        override val upperCondition: IfV<T>,
        data: Data = Data(), o: PreObjectV = preObjectV(data)
): PreObjectV by o, ElseIfV<T> {

    override fun new_(substitute: Boolean): ElseIfV<T> = ElseIfV_(condition, t, upperCondition, data_.copy(substitute = substitute))

    val elements_ = arrayListOf(upperCondition.addElse_(ifV(condition, t)))

    override fun elements(): List<ObjectV> = elements_

    override fun vElseIf(condition: BooleanV, block: () -> T): ElseIfV<T> = elseIfV(condition, block(), this)

    override fun vElse(block: () -> T): ElseV<T> = elseV(block(), this)

    companion object {
        fun <T: ObjectV> elseIfV(condition: BooleanV, t: T, upperCondition: IfV<T>): ElseIfV<T> = ElseIfV_(condition, t, upperCondition)
    }

}

