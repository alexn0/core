/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.function.function

import com.opt2code.core.function.function.operation.InvokeFunctionV
import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.PreObjectV

interface FunctionV<S: ObjectV, T: ObjectV>: PreObjectV {
    val mapping: (S) -> T

    operator fun invoke(t: S): T

    fun invokeOperation(t: S): InvokeFunctionV<S, T>

    fun getInterfaceClass(): Class<*> = FunctionV::class.java
}

