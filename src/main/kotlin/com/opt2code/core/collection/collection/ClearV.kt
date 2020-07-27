/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.collection.collection

import com.opt2code.core.collection.CollectionV
import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.ObjectVisitor

interface ClearV: ObjectV {
    val first: CollectionV<*>

    override fun getInterfaceClass(): Class<*> = ClearV::class.java

    override fun elements(): List<ObjectV> = arrayListOf(first)

    fun accept(r: ClearVisitor) {
        r.visit(this)
    }

    override fun accept(r: ObjectVisitor) {
        if (r is ClearVisitor) {
            r.visit(this)
        } else {
            r.visit(this)
        }
    }

}