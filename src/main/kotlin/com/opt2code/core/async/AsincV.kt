/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.async

import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.ObjectVisitor

interface AsyncV: ObjectV {
    override fun getInterfaceClass(): Class<*> = AsyncV::class.java

    fun accept(r: AsyncVisitor) {
        r.visit(this)
    }

    override fun accept(r: ObjectVisitor) {
        if (r is AsyncVisitor) {
            r.visit(this)
        } else {
            r.visit(this)
        }
    }
}

