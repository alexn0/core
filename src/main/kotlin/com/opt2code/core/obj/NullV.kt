/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.obj

interface NullV: ObjectV {

    fun accept(r: NullVisitor) {
        r.visit(this)
    }

    override fun accept(r: ObjectVisitor) {
        if (r is NullVisitor) {
            r.visit(this)
        } else {
            r.visit(this)
        }
    }


    override fun getInterfaceClass(): Class<*> = NullV::class.java
}

fun ObjectV?.nullV(): ObjectV = this ?: nullV()

