/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.date

import com.opt2code.core.obj.ComparableV
import com.opt2code.core.obj.ObjectVisitor
import com.opt2code.core.persistence.SQLPrimitiveV

interface DateV: ComparableV, SQLPrimitiveV {

    override fun getInterfaceClass(): Class<*> = DateV::class.java

    fun accept(r: DateVisitor) {
        r.visit(this)
    }

    override fun accept(r: ObjectVisitor) {
        if (r is DateVisitor) {
            r.visit(this)
        } else {
            r.visit(this)
        }
    }

}