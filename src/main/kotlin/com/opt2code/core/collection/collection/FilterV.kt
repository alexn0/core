/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.collection.collection

import com.opt2code.core.bool.BooleanV
import com.opt2code.core.collection.CollectionV
import com.opt2code.core.function.function.operation.InvokeFunctionV
import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.ObjectVisitor

interface FilterV<S: ObjectV>: ObjectV {
    val third: InvokeFunctionV<S, BooleanV>
    val fourth: S
    val first: CollectionV<S>
    val second: CollectionV<S>

    override fun elements(): List<ObjectV> = arrayListOf(first, third)

    override fun getInterfaceClass(): Class<*> = FilterV::class.java

    fun accept(r: FilterVisitor) {
        r.visit(this)
    }

    override fun accept(r: ObjectVisitor) {
        if (r is FilterVisitor) {
            r.visit(this)
        } else {
            r.visit(this)
        }
    }

}