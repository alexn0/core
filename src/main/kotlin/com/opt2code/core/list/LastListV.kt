/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.list

import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.ObjectVisitor

interface LastListV<S: ObjectV>: ObjectV {
    val obj: ListV<S>

    override fun elements(): List<ObjectV> = arrayListOf(obj)

    override fun getInterfaceClass(): Class<*> = LastListV::class.java

    fun accept(r: LastListVisitor) {
        r.visit(this)
    }

    override fun accept(r: ObjectVisitor) {
        if (r is LastListVisitor) {
            r.visit(this)
        } else {
            r.visit(this)
        }
    }

}