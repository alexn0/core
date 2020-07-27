/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.function.consume

import com.opt2code.core.function.consume.operation.InvokeConsumerV
import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.PreObjectV

interface ConsumerV<T: ObjectV>: PreObjectV {
    val mapping: (T) -> ObjectV

    operator fun invoke(t: T): T

    fun invokeOperation(t: T): InvokeConsumerV<T>

    fun getInterfaceClass(): Class<*> = ConsumerV::class.java

    fun accept(r: ConsumerVisitor) {
        r.visit(this)
    }
}