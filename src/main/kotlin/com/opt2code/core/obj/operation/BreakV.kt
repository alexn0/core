/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.obj.operation

import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.ObjectVisitor

interface BreakV: ObjectV {
    override fun getInterfaceClass(): Class<*> = BreakV::class.java

    fun accept(r: BreakVisitor) {
        r.visit(this)
    }

    override fun accept(r: ObjectVisitor) {
        if (r is BreakVisitor) {
            r.visit(this)
        } else {
            r.visit(this)
        }
    }
}

