/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.function.consume.operation

import com.opt2code.core.function.arg.AsFunctionV_.Companion.asFunctionV
import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.ObjectVisitor

interface InvokeConsumerV<T: ObjectV>: ObjectV {
    val value: ObjectV
    val arg: T

    override fun elements(): List<ObjectV> = arrayListOf(asFunctionV(value, arg), arg)

    override fun getInterfaceClass(): Class<*> = InvokeConsumerV::class.java

    override fun accept(r: ObjectVisitor) {
        if (r is InvokeConsumerVisitor) {
            r.visit(this)
        } else {
            r.visit(this)
        }
    }


    fun accept(r: InvokeConsumerVisitor) {
        r.visit(this)
    }
}


