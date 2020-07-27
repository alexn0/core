/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.collection.collection

import com.opt2code.core.collection.CollectionV
import com.opt2code.core.function.consume.operation.InvokeConsumerV
import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.ObjectVisitor

interface ForEachV<S: ObjectV>: ObjectV {
    val second: InvokeConsumerV<S>
    val first: CollectionV<S>

    override fun elements(): List<ObjectV> = arrayListOf(first, second)

    override fun getInterfaceClass(): Class<*> = ForEachV::class.java

    fun accept(r: ForEachVisitor) {
        r.visit(this)
    }

    override fun accept(r: ObjectVisitor) {
        if (r is ForEachVisitor) {
            r.visit(this)
        } else {
            r.visit(this)
        }
    }

}