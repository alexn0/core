/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.map

import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.ObjectVisitor

interface ToSetMapV<S: ObjectV, T: ObjectV>: ObjectV {
    val obj: MapV<S, T>

    override fun elements(): List<ObjectV> = arrayListOf(obj)

    override fun getInterfaceClass(): Class<*> = ToSetMapV::class.java

    fun accept(r: ToSetMapVisitor) {
        r.visit(this)
    }

    override fun accept(r: ObjectVisitor) {
        if (r is ToSetMapVisitor) {
            r.visit(this)
        } else {
            r.visit(this)
        }
    }

}