/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.stack

import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.ObjectVisitor

interface PeekStackV<S: ObjectV>: ObjectV {
    val obj: StackV<S>

    override fun elements(): List<ObjectV> = arrayListOf(obj)

    override fun getInterfaceClass(): Class<*> = PeekStackV::class.java

    fun accept(r: PeekStackVisitor) {
        r.visit(this)
    }

    override fun accept(r: ObjectVisitor) {
        if (r is PeekStackVisitor) {
            r.visit(this)
        } else {
            r.visit(this)
        }
    }

}