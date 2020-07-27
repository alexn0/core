/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.function.arg

import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.ObjectVisitor

interface AsArgReplacementV: ObjectV {
    val hiddenElement: ObjectV
    val isUse: Boolean

    override fun getInterfaceClass(): Class<*> = AsArgReplacementV::class.java

    fun accept(r: AsArgReplacementVisitor) {
        r.visit(this)
    }

    override fun accept(r: ObjectVisitor) {
        if (r is AsArgReplacementVisitor) {
            r.visit(this)
        } else {
            r.visit(this)
        }
    }

}