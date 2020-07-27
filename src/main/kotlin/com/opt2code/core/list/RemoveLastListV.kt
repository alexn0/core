/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.list

import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.ObjectVisitor

interface RemoveLastListV<S: ObjectV>: ObjectV {
    val obj: ListV<S>

    override fun elements(): List<ObjectV> = arrayListOf(obj)

    override fun getInterfaceClass(): Class<*> = RemoveLastListV::class.java

    fun accept(r: RemoveLastListVisitor) {
        r.visit(this)
    }

    override fun accept(r: ObjectVisitor) {
        if (r is RemoveLastListVisitor) {
            r.visit(this)
        } else {
            r.visit(this)
        }
    }

}