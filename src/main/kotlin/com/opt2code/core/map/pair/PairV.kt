/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.map.pair

import com.opt2code.core.cell.CellV
import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.ObjectVisitor

interface PairV<S: ObjectV, T: ObjectV>: ObjectV {
    val key: CellV<S>
    val value: CellV<T>

    override fun getInterfaceClass(): Class<*> = PairV::class.java

    fun accept(r: PairVisitor) {
        r.visit(this)
    }

    override fun accept(r: ObjectVisitor) {
        if (r is PairVisitor) {
            r.visit(this)
        } else {
            super.accept(r)
        }
    }

}