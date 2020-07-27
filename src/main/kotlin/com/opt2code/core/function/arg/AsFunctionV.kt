/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.function.arg

import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.ObjectVisitor

interface AsFunctionV<S: ObjectV>: ObjectV {

    fun hiddenElements(): List<ObjectV>

    fun hiddenMainElement(): ObjectV

    override fun getInterfaceClass(): Class<*> = AsFunctionV::class.java

    fun accept(r: AsFunctionVisitor) {
        r.visit(this)
    }

    override fun accept(r: ObjectVisitor) {
        if (r is AsFunctionVisitor) {
            r.visit(this)
        } else {
            r.visit(this)
        }
    }

}

