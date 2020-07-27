/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.function.predicate

import com.opt2code.core.bool.BooleanV
import com.opt2code.core.function.function.FunctionV
import com.opt2code.core.function.function.FunctionV_
import com.opt2code.core.obj.Data
import com.opt2code.core.obj.ObjectV

class PredicateV_<T: ObjectV> private constructor(
        private val functionV: FunctionV<T, BooleanV>
): PredicateV<T>, FunctionV<T, BooleanV> by functionV {


    companion object {
        fun <T: ObjectV> predicateV(
                data: Data = Data(),
                mapping: (T) -> BooleanV
        ): PredicateV<T> = PredicateV_(FunctionV_.functionV(data, mapping))
    }

    override fun getInterfaceClass(): Class<*> {
        return super<PredicateV>.getInterfaceClass()
    }
}