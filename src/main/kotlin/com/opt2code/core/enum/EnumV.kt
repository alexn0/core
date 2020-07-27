/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.enum

import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.ObjectVisitor
import com.opt2code.core.persistence.SQLPrimitiveV

interface EnumV<T: Enum<T>>: ObjectV, SQLPrimitiveV {
    val enumClass: Class<T>


    override fun getInterfaceClass(): Class<*> = EnumV::class.java

    fun accept(r: EnumVisitor) {
        r.visit(this)
    }

    override fun accept(r: ObjectVisitor) {
        if (r is EnumVisitor) {
            r.visit(this)
        } else {
            r.visit(this)
        }
    }

}