/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.collection.collection

import com.opt2code.core.collection.CollectionV
import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.ObjectVisitor

interface AddAllToCollectionV<S: ObjectV>: ObjectV {
    val second: CollectionV<S>
    val first: CollectionV<S>

    override fun elements(): List<ObjectV> = arrayListOf(first, second)

    override fun getInterfaceClass(): Class<*> = AddAllToCollectionV::class.java

    fun accept(r: AddAllToCollectionVisitor) {
        r.visit(this)
    }

    override fun accept(r: ObjectVisitor) {
        if (r is AddAllToCollectionVisitor) {
            r.visit(this)
        } else {
            r.visit(this)
        }
    }

}