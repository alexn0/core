/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.map.map

import com.opt2code.core.bool.BooleanV
import com.opt2code.core.map.MapV
import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.ObjectVisitor

interface ContainsKeyOperationV<S: ObjectV, T: ObjectV>: BooleanV {
    val arg: S
    val mapping: MapV<S, T>

    override fun elements(): List<ObjectV> = arrayListOf(mapping, arg)


    override fun getInterfaceClass(): Class<*> = ContainsKeyOperationV::class.java

    fun accept(r: ContainsKeyOperationVisitor) {
        r.visit(this)
    }

    override fun accept(r: ObjectVisitor) {
        if (r is ContainsKeyOperationVisitor) {
            r.visit(this)
        } else {
            super.accept(r)
        }
    }

}