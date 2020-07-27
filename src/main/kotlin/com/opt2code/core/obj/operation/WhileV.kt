/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.obj.operation

import com.opt2code.core.bool.BooleanV
import com.opt2code.core.function.arg.AsFunctionV_.Companion.asFunctionV
import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.ObjectVisitor
import com.opt2code.core.obj.operation

interface WhileV<T: ObjectV>: ObjectV {
    val condition: BooleanV
    val t: T

    override fun elements(): List<ObjectV> = arrayListOf(asFunctionV(condition), asFunctionV(t))

    operator fun invoke(): T = t.operation(this)

    fun accept(r: WhileVisitor) {
        r.visit(this)
    }

    override fun accept(r: ObjectVisitor) {
        if (r is WhileVisitor) {
            r.visit(this)
        } else {
            r.visit(this)
        }
    }


    override fun getInterfaceClass(): Class<*> = WhileV::class.java
}