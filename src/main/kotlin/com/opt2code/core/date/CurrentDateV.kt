/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.date

import com.opt2code.core.obj.ObjectVisitor

interface CurrentDateV: DateV {
    override fun getInterfaceClass(): Class<*> = CurrentDateV::class.java

    fun accept(r: CurrentDateVisitor) {
        r.visit(this)
    }

    override fun accept(r: ObjectVisitor) {
        if (r is CurrentDateVisitor) {
            r.visit(this)
        } else {
            super.accept(r)
        }
    }

}