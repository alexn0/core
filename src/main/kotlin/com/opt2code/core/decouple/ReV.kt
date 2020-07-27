/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.decouple

import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.ObjectVisitor

interface ReV<S: ObjectV, T: ObjectV>: ObjectV {
    operator fun invoke(): T

    fun wrappedValue(): S

    fun argValue(): S

    override fun getInterfaceClass(): Class<*> = ReV::class.java

    fun accept(r: ReVisitor) {
        r.visit(this)
    }

    override fun accept(r: ObjectVisitor) {
        if (r is ReVisitor) {
            r.visit(this)
        } else {
            r.visit(this)
        }
    }

}