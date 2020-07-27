/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.bool.comparable

import com.opt2code.core.bool.BooleanV
import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.ObjectVisitor

interface NotOperationV: BooleanV {
    val v: BooleanV

    override fun elements(): List<ObjectV> = arrayListOf(v)

    override fun getInterfaceClass(): Class<*> = NotOperationV::class.java

    fun accept(r: NotOperationVisitor) {
        r.visit(this)
    }

    override fun accept(r: ObjectVisitor) {
        if (r is NotOperationVisitor) {
            r.visit(this)
        } else {
            super.accept(r)
        }
    }

}