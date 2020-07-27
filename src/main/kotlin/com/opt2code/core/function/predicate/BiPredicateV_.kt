/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.function.predicate

import com.opt2code.core.bool.BooleanV
import com.opt2code.core.function.function.BiFunctionV
import com.opt2code.core.function.function.BiFunctionV_.Companion.biFunctionV
import com.opt2code.core.obj.Data
import com.opt2code.core.obj.ObjectV


class BiPredicateV_<S: ObjectV, T: ObjectV> private constructor(
        private val biFunctionV: BiFunctionV<S, T, BooleanV>
): BiPredicateV<S, T>, BiFunctionV<S, T, BooleanV> by biFunctionV {


    companion object {
        fun <S: ObjectV, T: ObjectV> biPredicate(
                data: Data = Data(),
                mapping: (S, T) -> BooleanV
        ): BiPredicateV<S, T> = BiPredicateV_(biFunctionV(data, mapping))
    }

    override fun getInterfaceClass(): Class<*> {
        return super<BiPredicateV>.getInterfaceClass()
    }
}