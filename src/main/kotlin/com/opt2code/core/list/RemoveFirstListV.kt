/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.list

import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.ObjectVisitor

interface RemoveFirstListV<S: ObjectV>: ObjectV {
    val obj: ListV<S>

    override fun elements(): List<ObjectV> = arrayListOf(obj)

    override fun getInterfaceClass(): Class<*> = RemoveFirstListV::class.java

    fun accept(r: RemoveFirstListVisitor) {
        r.visit(this)
    }

    override fun accept(r: ObjectVisitor) {
        if (r is RemoveFirstListVisitor) {
            r.visit(this)
        } else {
            r.visit(this)
        }
    }

}