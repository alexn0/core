/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.function.predicate

import com.opt2code.core.bool.BooleanV
import com.opt2code.core.function.function.BiFunctionV
import com.opt2code.core.obj.ObjectV

interface BiPredicateV<S: ObjectV, T: ObjectV>: BiFunctionV<S, T, BooleanV> {
    override fun getInterfaceClass(): Class<*> = BiPredicateV::class.java
}