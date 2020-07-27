/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.function.function.operation

import com.opt2code.core.function.arg.AsFunctionV_.Companion.asFunctionV
import com.opt2code.core.function.function.operation.ReplaceArgForInvokeFunctionV_.Companion.replaceArgForInvokeFunctionV
import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.ObjectVisitor
import com.opt2code.core.obj.new

import com.opt2code.core.obj.operation

interface InvokeFunctionV<S: ObjectV, T: ObjectV>: ObjectV {
    val value: T
    val arg: S

    override fun elements(): List<ObjectV> = arrayListOf(asFunctionV(value, arg), arg)

    operator fun invoke(t: S): T = value.new().operation(replaceArgForInvokeFunctionV(value, t, arg))

    override fun getInterfaceClass(): Class<*> = InvokeFunctionV::class.java

    override fun accept(r: ObjectVisitor) {
        if (r is InvokeFunctionVisitor) {
            r.visit(this)
        } else {
            r.visit(this)
        }
    }


    fun accept(r: InvokeFunctionVisitor) {
        r.visit(this)
    }
}

