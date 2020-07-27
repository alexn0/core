/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.obj

interface PrevV<S: ObjectV, T: ObjectV>: ObjectV {
    val s: S
    val t: T

    override fun getInterfaceClass(): Class<*> = PrevV::class.java

    fun accept(r: PrevVisitor) {
        r.visit(this)
    }

    override fun accept(r: ObjectVisitor) {
        if (r is PrevVisitor) {
            r.visit(this)
        } else {
            r.visit(this)
        }
    }

}