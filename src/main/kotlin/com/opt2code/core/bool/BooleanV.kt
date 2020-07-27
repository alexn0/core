/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.bool

import com.opt2code.core.bool.comparable.NotOperationV
import com.opt2code.core.bool.comparable.NotOperationV_.Companion.notOperationV
import com.opt2code.core.obj.ComparableV
import com.opt2code.core.obj.ObjectVisitor
import com.opt2code.core.persistence.SQLPrimitiveV

interface BooleanV: ComparableV, SQLPrimitiveV {
    fun not(): NotOperationV = notOperationV(this)

    fun accept(r: BooleanVisitor) {
        r.visit(this)
    }

    override fun accept(r: ObjectVisitor) {
        if (r is BooleanVisitor) {
            r.visit(this)
        } else {
            r.visit(this)
        }
    }

    override fun getInterfaceClass(): Class<*> = BooleanV::class.java
}