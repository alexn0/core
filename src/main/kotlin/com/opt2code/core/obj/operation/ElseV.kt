/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.obj.operation

import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.ObjectVisitor
import com.opt2code.core.obj.new
import com.opt2code.core.obj.operation

interface ElseV<T: ObjectV>: ObjectV {
    val upperCondition: IfV<T>
    val t: T

    operator fun invoke(): T = t.new(substitute = true).operation(this)

    fun accept(r: ElseVisitor) {
        r.visit(this)
    }

    override fun accept(r: ObjectVisitor) {
        if (r is ElseVisitor) {
            r.visit(this)
        } else {
            r.visit(this)
        }
    }


    override fun getInterfaceClass(): Class<*> = ElseV::class.java
}