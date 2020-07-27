/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.bool.comparable

import com.opt2code.core.bool.BooleanV
import com.opt2code.core.obj.ComparableV
import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.ObjectVisitor

interface GtOrEqV<T: ComparableV>: BooleanV {
    val first: T
    val second: T

    override fun elements(): List<ObjectV> = arrayListOf(first, second)

    fun accept(r: GtOrEqVisitor) {
        r.visit(this)
    }

    override fun accept(r: ObjectVisitor) {
        if (r is GtOrEqVisitor) {
            r.visit(this)
        } else {
            super.accept(r)
        }
    }

    override fun getInterfaceClass(): Class<*> = GtOrEqV::class.java
}