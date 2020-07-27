/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.collection.collection

import com.opt2code.core.collection.CollectionV
import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.ObjectVisitor

interface IsEmptyCollectionV: ObjectV {
    val first: CollectionV<out ObjectV>

    override fun elements(): List<ObjectV> = arrayListOf(first)

    override fun getInterfaceClass(): Class<*> = IsEmptyCollectionV::class.java

    fun accept(r: IsEmptyCollectionVisitor) {
        r.visit(this)
    }

    override fun accept(r: ObjectVisitor) {
        if (r is IsEmptyCollectionVisitor) {
            r.visit(this)
        } else {
            r.visit(this)
        }
    }

}