/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.cell

import com.opt2code.core.decouple.DecouplingV_.Companion.decouple
import com.opt2code.core.obj.ObjectV

class Vl<T: ObjectV> private constructor(
        private val t: () -> T,
        val value: T
) {

    operator fun invoke() = decouple(t()) { value }

    companion object {
        fun <T: ObjectV> vl(t: () -> T, value: T = t()): Vl<T> = Vl<T>(t, value)
    }
}

