/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.function.consume

import com.opt2code.core.function.consume.operation.InvokeBiConsumerV
import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.PreObjectV

interface BiConsumerV<S: ObjectV, T: ObjectV>: PreObjectV {
    val mapping: (S, T) -> ObjectV

    operator fun invoke(s: S, t: T): S

    fun invokeOperation(s: S, t: T): InvokeBiConsumerV<S, T>

    fun getInterfaceClass(): Class<*> = BiConsumerV::class.java

    fun accept(r: BiConsumerVisitor) {
        r.visit(this)
    }
}


