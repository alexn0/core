/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.obj.operation

import com.opt2code.core.error.ErrorV
import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.ObjectVisitor
import com.opt2code.core.obj.operation

interface TryV<T: ObjectV>: ObjectV {
    val t: T

    override fun elements(): List<ObjectV> = arrayListOf(t)

    fun vCatch(error: ErrorV, block: () -> T): CatchV<T>

    fun vFinally(block: () -> T): FinallyV<T>

    fun value(): T = t.operation(this).also { t.isNullable = true }

    fun accept(r: TryVisitor) {
        r.visit(this)
    }

    override fun accept(r: ObjectVisitor) {
        if (r is TryVisitor) {
            r.visit(this)
        } else {
            r.visit(this)
        }
    }


    override fun getInterfaceClass(): Class<*> = TryV::class.java
}