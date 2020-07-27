/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.cell

import com.opt2code.core.expression.QExprCommonV
import com.opt2code.core.metadata.meta.FieldNameMeta
import com.opt2code.core.metadata.meta.OrderingMeta
import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.ObjectVisitor

interface CellV<T: ObjectV>: ObjectV, PreCellV<T>, QExprCommonV<T>, OrderingMeta, FieldNameMeta {

    override fun elements(): List<ObjectV> = arrayListOf(t_)

    fun accept(r: CellVisitor) {
        r.visit(this)
    }

    override fun accept(r: ObjectVisitor) {
        if (r is CellVisitor) {
            r.visit(this)
        } else {
            r.visit(this)
        }
    }


    override fun getInterfaceClass(): Class<*> = CellV::class.java
}



