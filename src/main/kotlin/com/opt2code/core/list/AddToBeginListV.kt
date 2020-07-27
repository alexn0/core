/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.list

import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.ObjectVisitor

interface AddToBeginListV<S: ObjectV>: ObjectV {
    val arg: S
    val obj: ListV<S>
    override fun getInterfaceClass(): Class<*> = AddToBeginListV::class.java

    fun accept(r: AddToBeginListVisitor) {
        r.visit(this)
    }

    override fun accept(r: ObjectVisitor) {
        if (r is AddToBeginListVisitor) {
            r.visit(this)
        } else {
            r.visit(this)
        }
    }

}