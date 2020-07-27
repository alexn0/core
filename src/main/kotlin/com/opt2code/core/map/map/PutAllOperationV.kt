/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.map.map

import com.opt2code.core.map.MapV
import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.ObjectVisitor

interface PutAllOperationV<S: ObjectV, T: ObjectV>: ObjectV {
    val arg: MapV<S, T>

    override fun elements(): List<ObjectV> = arrayListOf(arg)

    override fun getInterfaceClass(): Class<*> = PutAllOperationV::class.java

    fun accept(r: PutAllOperationVisitor) {
        r.visit(this)
    }

    override fun accept(r: ObjectVisitor) {
        if (r is PutAllOperationVisitor) {
            r.visit(this)
        } else {
            r.visit(this)
        }
    }

}