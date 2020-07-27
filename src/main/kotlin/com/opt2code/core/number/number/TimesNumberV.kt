/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.number.number

import com.opt2code.core.number.NumberV
import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.ObjectVisitor


interface TimesNumberV: NumberV {
    val first: NumberV
    val second: NumberV

    override fun elements(): List<ObjectV> = arrayListOf(first, second)

    fun accept(r: TimesNumberVisitor) {
        r.visit(this)
    }

    override fun accept(r: ObjectVisitor) {
        if (r is TimesNumberVisitor) {
            r.visit(this)
        } else {
            super.accept(r)
        }
    }

    override fun getInterfaceClass(): Class<*> = TimesNumberV::class.java
}