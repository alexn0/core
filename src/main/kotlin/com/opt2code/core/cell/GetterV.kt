/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.cell

import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.ObjectVisitor

interface GetterV<T: ObjectV>: ObjectV {

    fun accept(r: GetterVisitor) {
        r.visit(this)
    }

    override fun accept(r: ObjectVisitor) {
        if (r is GetterVisitor) {
            r.visit(this)
        } else {
            r.visit(this)
        }
    }


    override fun getInterfaceClass(): Class<*> = GetterV::class.java
}

