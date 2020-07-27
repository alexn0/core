/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.obj.operation

import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.ObjectVisitor

interface ContinueV: ObjectV {
    override fun getInterfaceClass(): Class<*> = ContinueV::class.java

    fun accept(r: ContinueVisitor) {
        r.visit(this)
    }

    override fun accept(r: ObjectVisitor) {
        if (r is ContinueVisitor) {
            r.visit(this)
        } else {
            r.visit(this)
        }
    }

}