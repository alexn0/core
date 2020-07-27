/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.bool.comparable

import com.opt2code.core.bool.BooleanV
import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.ObjectVisitor

interface OrV: BooleanV {
    val first: ObjectV
    val second: ObjectV

    override fun elements(): List<ObjectV> = arrayListOf(first, second)

    fun accept(r: OrVisitor) {
        r.visit(this)
    }

    override fun accept(r: ObjectVisitor) {
        if (r is OrVisitor) {
            r.visit(this)
        } else {
            super.accept(r)
        }
    }


    override fun getInterfaceClass(): Class<*> = NeqV::class.java
}

