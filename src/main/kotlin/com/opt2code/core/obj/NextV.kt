/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.obj

interface NextV<S: ObjectV, T: ObjectV>: ObjectV {
    val s: S
    val t: T

    override fun elements(): List<ObjectV> = arrayListOf(s, t)

    override fun getInterfaceClass(): Class<*> = NextV::class.java

    fun accept(r: NextVisitor) {
        r.visit(this)
    }

    override fun accept(r: ObjectVisitor) {
        if (r is NextVisitor) {
            r.visit(this)
        } else {
            r.visit(this)
        }
    }
}