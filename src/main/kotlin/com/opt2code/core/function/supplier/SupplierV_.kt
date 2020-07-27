/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.function.supplier

import com.opt2code.core.function.arg.AsFunctionV_.Companion.asFunctionV
import com.opt2code.core.obj.Data
import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.PreObjectV
import com.opt2code.core.obj.PreObjectV_

class SupplierV_<S: ObjectV> private constructor(
        private val arg: () -> S,
        data: Data,
        o: PreObjectV = PreObjectV_.preObjectV(data)
): SupplierV<S>, PreObjectV by o {

    override fun new_(substitute: Boolean): SupplierV<S> = SupplierV_(arg, data_.copy(substitute = substitute))

    override fun invoke(): S = arg()

    override fun elements(): List<ObjectV> = arrayListOf(asFunctionV(arg()))

    companion object {
        fun <S: ObjectV> supplierV(data: Data = Data(), arg: () -> S): SupplierV<S> = SupplierV_<S>(arg, data)
    }
}