/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.obj.operation

import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.ObjectVisitor
import com.opt2code.core.obj.operation

interface FinallyV<T: ObjectV>: ObjectV {
    val upperCondition: TryV<T>
    val t: T

    override fun elements(): List<ObjectV> = arrayListOf(t, upperCondition)

    operator fun invoke(): T = t.operation(this)

    fun accept(r: FinallyVisitor) {
        r.visit(this)
    }

    override fun accept(r: ObjectVisitor) {
        if (r is FinallyVisitor) {
            r.visit(this)
        } else {
            r.visit(this)
        }
    }

    override fun getInterfaceClass(): Class<*> = FinallyV::class.java
}