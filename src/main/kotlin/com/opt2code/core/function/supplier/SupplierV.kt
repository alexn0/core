/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.function.supplier

import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.ObjectVisitor

interface SupplierV<S: ObjectV>: ObjectV {
    operator fun invoke(): S

    override fun getInterfaceClass(): Class<*> = SupplierV::class.java

    override fun accept(r: ObjectVisitor) {
        if (r is SupplierVisitor) {
            r.visit(this)
        } else {
            r.visit(this)
        }
    }


    fun accept(r: SupplierVisitor) {
        r.visit(this)
    }
}

