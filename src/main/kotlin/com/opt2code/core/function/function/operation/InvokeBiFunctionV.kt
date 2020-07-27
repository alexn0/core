/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.function.function.operation

import com.opt2code.core.function.arg.AsFunctionV_.Companion.asFunctionV
import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.ObjectVisitor

interface InvokeBiFunctionV<S: ObjectV, T: ObjectV, U: ObjectV>: ObjectV {
    val value: U
    val arg1: S
    val arg2: T

    override fun elements(): List<ObjectV> = arrayListOf(asFunctionV(value, arg1, arg2), arg1, arg2)

    override fun getInterfaceClass(): Class<*> = InvokeBiFunctionV::class.java

    override fun accept(r: ObjectVisitor) {
        if (r is InvokeBiFunctionVisitor) {
            r.visit(this)
        } else {
            r.visit(this)
        }
    }


    fun accept(r: InvokeBiFunctionVisitor) {
        r.visit(this)
    }
}