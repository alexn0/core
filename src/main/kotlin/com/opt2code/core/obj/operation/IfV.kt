/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.obj.operation

import com.opt2code.core.bool.BooleanV
import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.ObjectVisitor
import com.opt2code.core.obj.operation
import com.opt2code.core.obj.operation.IfElseV_.Companion.ifElseV

interface IfV<T: ObjectV>: ObjectV {
    val condition: BooleanV
    val t: T

    fun addElse_(s: ObjectV): IfElseV<T> {
        return ifElseV(condition, t, s)
    }

    fun vElseIf(condition: BooleanV, block: () -> T): ElseIfV<T>

    fun vElse(block: () -> T): ElseV<T>

    fun value(): T = t.operation(this).also { t.isNullable = true }

    fun accept(r: IfVisitor) {
        r.visit(this)
    }

    override fun accept(r: ObjectVisitor) {
        if (r is IfVisitor) {
            r.visit(this)
        } else {
            r.visit(this)
        }
    }

    override fun getInterfaceClass(): Class<*> = IfV::class.java
}


