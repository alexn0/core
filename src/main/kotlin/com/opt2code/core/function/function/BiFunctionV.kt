/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.function.function

import com.opt2code.core.function.function.operation.InvokeBiFunctionV
import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.PreObjectV

interface BiFunctionV<S: ObjectV, T: ObjectV, U: ObjectV>: PreObjectV {
    val mapping: (S, T) -> U

    operator fun invoke(s: S, t: T): U

    fun invokeOperation(s: S, t: T): InvokeBiFunctionV<S, T, U>

    fun getInterfaceClass(): Class<*> = BiFunctionV::class.java
}