/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.stack

import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.ObjectVisitor

interface SearchStackV<S: ObjectV>: ObjectV {
    val arg: S
    val obj: StackV<S>

    override fun elements(): List<ObjectV> = arrayListOf(obj, arg)

    override fun getInterfaceClass(): Class<*> = SearchStackV::class.java

    fun accept(r: SearchStackVisitor) {
        r.visit(this)
    }

    override fun accept(r: ObjectVisitor) {
        if (r is SearchStackVisitor) {
            r.visit(this)
        } else {
            r.visit(this)
        }
    }

}