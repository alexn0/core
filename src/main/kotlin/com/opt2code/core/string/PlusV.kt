/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.string

import com.opt2code.core.obj.ObjectVisitor

interface PlusV: StringV {
    val arg1: StringV
    val arg2: StringV
    override fun getInterfaceClass(): Class<*> = PlusV::class.java

    fun accept(r: PlusVisitor) {
        r.visit(this)
    }

    override fun accept(r: ObjectVisitor) {
        if (r is PlusVisitor) {
            r.visit(this)
        } else {
            super.accept(r)
        }
    }

}