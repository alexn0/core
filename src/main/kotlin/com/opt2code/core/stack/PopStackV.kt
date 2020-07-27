/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.stack

import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.ObjectVisitor

interface PopStackV<S: ObjectV>: ObjectV {
    val obj: StackV<S>

    override fun elements(): List<ObjectV> = arrayListOf(obj)

    override fun getInterfaceClass(): Class<*> = PopStackV::class.java

    fun accept(r: PopStackVisitor) {
        r.visit(this)
    }

    override fun accept(r: ObjectVisitor) {
        if (r is PopStackVisitor) {
            r.visit(this)
        } else {
            r.visit(this)
        }
    }

}