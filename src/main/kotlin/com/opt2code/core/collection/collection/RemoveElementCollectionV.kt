/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.collection.collection

import com.opt2code.core.collection.CollectionV
import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.ObjectVisitor

interface RemoveElementCollectionV<S: ObjectV>: ObjectV {
    val second: S
    val first: CollectionV<S>

    override fun elements(): List<ObjectV> = arrayListOf(first, second)

    override fun getInterfaceClass(): Class<*> = RemoveElementCollectionV::class.java

    fun accept(r: RemoveElementCollectionVisitor) {
        r.visit(this)
    }

    override fun accept(r: ObjectVisitor) {
        if (r is RemoveElementCollectionVisitor) {
            r.visit(this)
        } else {
            r.visit(this)
        }
    }

}