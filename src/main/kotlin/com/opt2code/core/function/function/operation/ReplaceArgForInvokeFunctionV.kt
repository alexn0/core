/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.function.function.operation

import com.opt2code.core.function.arg.AsFunctionV_.Companion.asFunctionV
import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.ObjectVisitor

interface ReplaceArgForInvokeFunctionV<S: ObjectV, T: ObjectV>: ObjectV {
    val value: T
    val newArg: S
    val oldArg: S

    override fun elements(): List<ObjectV> = arrayListOf(asFunctionV(value, oldArg), newArg)

    override fun getInterfaceClass(): Class<*> = ReplaceArgForInvokeFunctionV::class.java

    override fun accept(r: ObjectVisitor) {
        if (r is ReplaceArgForInvokeFunctionVisitor) {
            r.visit(this)
        } else {
            r.visit(this)
        }
    }


    fun accept(r: ReplaceArgForInvokeFunctionVisitor) {
        r.visit(this)
    }
}