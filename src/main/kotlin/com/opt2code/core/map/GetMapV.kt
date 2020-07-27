/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.map

import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.ObjectVisitor

interface GetMapV<S: ObjectV, T: ObjectV>: ObjectV {
    val arg: S
    val obj: MapV<S, T>

    override fun elements(): List<ObjectV> = arrayListOf(obj, arg)

    override fun getInterfaceClass(): Class<*> = GetMapV::class.java

    fun accept(r: GetMapVisitor) {
        r.visit(this)
    }

    override fun accept(r: ObjectVisitor) {
        if (r is GetMapVisitor) {
            r.visit(this)
        } else {
            r.visit(this)
        }
    }

}