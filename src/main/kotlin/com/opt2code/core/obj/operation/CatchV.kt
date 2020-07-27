/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.obj.operation

import com.opt2code.core.error.ErrorV
import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.ObjectVisitor

interface CatchV<T: ObjectV>: TryV<T> {
    val error: ErrorV
    val upperCondition: TryV<T>

    override fun elements(): List<ObjectV> = arrayListOf(error, upperCondition)

    fun accept(r: CatchVisitor) {
        r.visit(this)
    }

    override fun accept(r: ObjectVisitor) {
        if (r is CatchVisitor) {
            r.visit(this)
        } else {
            r.visit(this)
        }
    }


    override fun getInterfaceClass(): Class<*> = CatchV::class.java
}