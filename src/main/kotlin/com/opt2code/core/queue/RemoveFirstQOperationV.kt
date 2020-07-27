/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.queue

import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.ObjectVisitor

interface RemoveFirstQOperationV<S: ObjectV>: ObjectV {
    val obj: QueueV<S>

    override fun elements(): List<ObjectV> = arrayListOf(obj)

    override fun getInterfaceClass(): Class<*> = RemoveFirstQOperationV::class.java

    fun accept(r: RemoveFirstQOperationVisitor) {
        r.visit(this)
    }

    override fun accept(r: ObjectVisitor) {
        if (r is RemoveFirstQOperationVisitor) {
            r.visit(this)
        } else {
            r.visit(this)
        }
    }

}