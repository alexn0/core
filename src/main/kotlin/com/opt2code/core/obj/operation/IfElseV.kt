/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.obj.operation

import com.opt2code.core.bool.BooleanV
import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.ObjectVisitor

interface IfElseV<T: ObjectV>: ObjectV {
    val condition: BooleanV
    val t: T
    val s: ObjectV


    fun accept(r: IfElseVisitor) {
        r.visit(this)
    }

    override fun accept(r: ObjectVisitor) {
        if (r is IfElseVisitor) {
            r.visit(this)
        } else {
            r.visit(this)
        }
    }

    override fun getInterfaceClass(): Class<*> = IfElseV::class.java

}