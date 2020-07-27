/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.function.consume.operation

import com.opt2code.core.function.arg.AsFunctionV_.Companion.asFunctionV
import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.ObjectVisitor

interface InvokeBiConsumerV<S: ObjectV, T: ObjectV>: ObjectV {
    val value: ObjectV
    val arg1: S
    val arg2: T

    override fun elements(): List<ObjectV> = arrayListOf(asFunctionV(value, arg1, arg2), arg1, arg2)

    override fun getInterfaceClass(): Class<*> = InvokeBiConsumerV::class.java

    override fun accept(r: ObjectVisitor) {
        if (r is InvokeBiConsumerVisitor) {
            r.visit(this)
        } else {
            r.visit(this)
        }
    }


    fun accept(r: InvokeBiConsumerVisitor) {
        r.visit(this)
    }
}