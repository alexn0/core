/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.queue

import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.ObjectVisitor

interface ElementFirstOperationV<S: ObjectV>: ObjectV {
    val obj: QueueV<S>

    override fun elements(): List<ObjectV> = arrayListOf(obj)

    override fun getInterfaceClass(): Class<*> = ElementFirstOperationV::class.java

    fun accept(r: ElementFirstOperationVisitor) {
        r.visit(this)
    }

    override fun accept(r: ObjectVisitor) {
        if (r is ElementFirstOperationVisitor) {
            r.visit(this)
        } else {
            r.visit(this)
        }
    }

}