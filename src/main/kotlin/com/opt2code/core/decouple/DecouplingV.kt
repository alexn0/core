/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.decouple

import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.ObjectVisitor

interface DecouplingV<S: ObjectV>: ObjectV {
    operator fun invoke(): S

    fun implementation(): S

    override fun getInterfaceClass(): Class<*> = DecouplingV::class.java

    fun accept(r: DecouplingVisitor) {
        r.visit(this)
    }

    override fun accept(r: ObjectVisitor) {
        if (r is DecouplingVisitor) {
            r.visit(this)
        } else {
            r.visit(this)
        }
    }

}