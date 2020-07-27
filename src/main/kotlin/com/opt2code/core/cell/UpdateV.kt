/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.cell

import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.ObjectVisitor

interface UpdateV<T: ObjectV>: ObjectV {
    val value: T

    fun accept(r: UpdateVisitor) {
        r.visit(this)
    }

    override fun accept(r: ObjectVisitor) {
        if (r is UpdateVisitor) {
            r.visit(this)
        } else {
            r.visit(this)
        }
    }


    override fun getInterfaceClass(): Class<*> = UpdateV::class.java
}

