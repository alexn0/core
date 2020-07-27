/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.function.predicate

import com.opt2code.core.bool.BooleanV
import com.opt2code.core.function.function.FunctionV
import com.opt2code.core.obj.ObjectV

interface PredicateV<T: ObjectV>: FunctionV<T, BooleanV> {
    override fun getInterfaceClass(): Class<*> = PredicateV::class.java

}