/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.map.map

import com.opt2code.core.map.MapV
import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.ObjectVisitor

interface PutOperationV<S: ObjectV, T: ObjectV>: ObjectV {
    val key: S
    val value: T
    val mapping: MapV<S, T>

    override fun elements(): List<ObjectV> = arrayListOf(mapping, key, value)

    override fun getInterfaceClass(): Class<*> = PutOperationV::class.java

    fun accept(r: PutOperationVisitor) {
        r.visit(this)
    }

    override fun accept(r: ObjectVisitor) {
        if (r is PutOperationVisitor) {
            r.visit(this)
        } else {
            super.accept(r)
        }
    }
}