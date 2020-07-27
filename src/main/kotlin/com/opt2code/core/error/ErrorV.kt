/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.error

import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.ObjectVisitor

interface ErrorV: ObjectV {
    override fun getInterfaceClass(): Class<*> = ErrorV::class.java

    fun accept(r: ErrorVisitor) {
        r.visit(this)
    }

    override fun accept(r: ObjectVisitor) {
        if (r is ErrorVisitor) {
            r.visit(this)
        } else {
            r.visit(this)
        }
    }

}