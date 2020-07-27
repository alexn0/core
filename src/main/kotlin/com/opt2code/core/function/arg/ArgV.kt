/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.function.arg

import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.ObjectVisitor

interface ArgV<S: ObjectV>: ObjectV {
    operator fun invoke(): S
    override fun getInterfaceClass(): Class<*> = ArgV::class.java

    fun accept(r: ArgVisitor) {
        r.visit(this)
    }

    override fun accept(r: ObjectVisitor) {
        if (r is ArgVisitor) {
            r.visit(this)
        } else {
            r.visit(this)
        }
    }

}

