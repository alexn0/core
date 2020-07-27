/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.set

import com.opt2code.core.collection.CollectionV
import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.ObjectVisitor

interface SetV<S: ObjectV>: CollectionV<S> {
    override fun <K: ObjectV> new(common: () -> K): SetV<K>

    override fun getInterfaceClass(): Class<*> = SetV::class.java

    fun accept(r: SetVisitor) {
        r.visit(this)
    }

    override fun accept(r: ObjectVisitor) {
        if (r is SetVisitor) {
            r.visit(this)
        } else {
            super.accept(r)
        }
    }

}

