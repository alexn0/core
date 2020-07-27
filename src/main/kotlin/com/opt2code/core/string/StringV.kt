/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.string

import com.opt2code.core.obj.ComparableV
import com.opt2code.core.obj.ObjectVisitor
import com.opt2code.core.persistence.SQLPrimitiveV
import com.opt2code.core.string.PlusV_.Companion.plusV

interface StringV: ComparableV, SQLPrimitiveV {
    fun accept(r: StringVisitor) {
        r.visit(this)
    }

    override fun accept(r: ObjectVisitor) {
        if (r is StringVisitor) {
            r.visit(this)
        } else {
            r.visit(this)
        }
    }


    operator fun plus(arg1: StringV): StringV = plusV(this, arg1)

    override fun getInterfaceClass(): Class<*> = StringV::class.java
}
