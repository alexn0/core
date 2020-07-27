/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.collection.collection

import com.opt2code.core.collection.CollectionV
import com.opt2code.core.function.function.operation.InvokeFunctionV
import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.ObjectVisitor

interface CollectionMappingV<S: ObjectV, T: ObjectV>: ObjectV {
    val third: InvokeFunctionV<S, T>
    val second: S
    val first: CollectionV<S>

    override fun elements(): List<ObjectV> = arrayListOf(first, third)

    override fun getInterfaceClass(): Class<*> = CollectionMappingV::class.java

    fun accept(r: CollectionMappingVisitor) {
        r.visit(this)
    }

    override fun accept(r: ObjectVisitor) {
        if (r is CollectionMappingVisitor) {
            r.visit(this)
        } else {
            r.visit(this)
        }
    }

}