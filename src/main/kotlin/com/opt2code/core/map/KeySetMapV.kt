/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.map

import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.ObjectVisitor

interface KeySetMapV<S: ObjectV, T: ObjectV>: ObjectV {
    val obj: MapV<S, T>

    override fun elements(): List<ObjectV> = arrayListOf(obj)

    override fun getInterfaceClass(): Class<*> = KeySetMapV::class.java

    fun accept(r: KeySetMapVisitor) {
        r.visit(this)
    }

    override fun accept(r: ObjectVisitor) {
        if (r is KeySetMapVisitor) {
            r.visit(this)
        } else {
            r.visit(this)
        }
    }

}