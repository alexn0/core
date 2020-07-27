/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.bool.comparable

import com.opt2code.core.bool.BooleanV
import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.ObjectVisitor

interface NeqV: BooleanV {
    val first: ObjectV
    val second: ObjectV

    override fun elements(): List<ObjectV> = arrayListOf(first, second)

    fun accept(r: NeqVisitor) {
        r.visit(this)
    }

    override fun accept(r: ObjectVisitor) {
        if (r is NeqVisitor) {
            r.visit(this)
        } else {
            super.accept(r)
        }
    }

    override fun getInterfaceClass(): Class<*> = NeqV::class.java
}

