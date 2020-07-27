/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.map

import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.ObjectVisitor

interface ValueListMapV<S: ObjectV, T: ObjectV>: ObjectV {
    val obj: MapV<S, T>

    override fun elements(): List<ObjectV> = arrayListOf(obj)

    override fun getInterfaceClass(): Class<*> = ValueListMapV::class.java

    fun accept(r: ValueListMapVisitor) {
        r.visit(this)
    }

    override fun accept(r: ObjectVisitor) {
        if (r is ValueListMapVisitor) {
            r.visit(this)
        } else {
            r.visit(this)
        }
    }

}