/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.collection.collection

import com.opt2code.core.collection.CollectionV
import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.ObjectVisitor

interface ContainsOperationCollectionV<S: ObjectV>: ObjectV {
    val second: S
    val first: CollectionV<S>

    override fun elements(): List<ObjectV> = arrayListOf(first, second)

    override fun getInterfaceClass(): Class<*> = ContainsOperationCollectionV::class.java

    fun accept(r: ContainsOperationCollectionVisitor) {
        r.visit(this)
    }

    override fun accept(r: ObjectVisitor) {
        if (r is ContainsOperationCollectionVisitor) {
            r.visit(this)
        } else {
            r.visit(this)
        }
    }

}