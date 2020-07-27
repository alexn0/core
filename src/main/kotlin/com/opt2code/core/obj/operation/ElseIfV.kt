/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.obj.operation

import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.ObjectVisitor
import com.opt2code.core.obj.new
import com.opt2code.core.obj.operation
import com.opt2code.core.obj.operation.IfElseV_.Companion.ifElseV


interface ElseIfV<T: ObjectV>: IfV<T> {
    val upperCondition: IfV<T>

    override fun addElse_(s: ObjectV): IfElseV<T> {
        return upperCondition.addElse_(ifElseV(condition, t, s))
    }

    operator fun invoke(): T = t.new(substitute = true).operation(this)

    fun accept(r: ElseIfVisitor) {
        r.visit(this)
    }

    override fun accept(r: ObjectVisitor) {
        if (r is ElseIfVisitor) {
            r.visit(this)
        } else {
            r.visit(this)
        }
    }

    override fun getInterfaceClass(): Class<*> = ElseIfV::class.java
}

