/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.function.arg

import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.ObjectVisitor

interface AsFunctionReplacementV: ObjectV {

    override fun getInterfaceClass(): Class<*> = AsFunctionReplacementV::class.java

    fun accept(r: AsFunctionReplacementVisitor) {
        r.visit(this)
    }

    override fun accept(r: ObjectVisitor) {
        if (r is AsFunctionReplacementVisitor) {
            r.visit(this)
        } else {
            r.visit(this)
        }
    }

}

