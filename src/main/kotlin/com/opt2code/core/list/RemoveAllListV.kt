/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.list

import com.opt2code.core.collection.CollectionV
import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.ObjectVisitor

interface RemoveAllListV<S: ObjectV>: ObjectV {
    val arg: CollectionV<S>
    val obj: ListV<S>

    override fun elements(): List<ObjectV> = arrayListOf(obj, arg)

    override fun getInterfaceClass(): Class<*> = RemoveAllListV::class.java

    fun accept(r: RemoveAllListVisitor) {
        r.visit(this)
    }

    override fun accept(r: ObjectVisitor) {
        if (r is RemoveAllListVisitor) {
            r.visit(this)
        } else {
            r.visit(this)
        }
    }

}