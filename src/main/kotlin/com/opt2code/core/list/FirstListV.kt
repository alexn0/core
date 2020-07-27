/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.list

import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.ObjectVisitor

interface FirstListV<S: ObjectV>: ObjectV {
    val obj: ListV<S>
    override fun getInterfaceClass(): Class<*> = FirstListV::class.java

    fun accept(r: FirstListVisitor) {
        r.visit(this)
    }

    override fun accept(r: ObjectVisitor) {
        if (r is FirstListVisitor) {
            r.visit(this)
        } else {
            r.visit(this)
        }
    }

}