/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.list

import com.opt2code.core.bool.BooleanV
import com.opt2code.core.bool.BooleanV_.Companion.booleanV
import com.opt2code.core.collection.CollectionV
import com.opt2code.core.list.AddToBeginListV_.Companion.addToBeginListV
import com.opt2code.core.list.FirstListV_.Companion.firstListV
import com.opt2code.core.list.LastListV_.Companion.lastListV
import com.opt2code.core.list.RemoveAllListV_.Companion.removeAllListV
import com.opt2code.core.list.RemoveFirstListV_.Companion.removeFirstListV
import com.opt2code.core.list.RemoveLastListV_.Companion.removeLastListV
import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.ObjectVisitor
import com.opt2code.core.obj.operation


interface ListV<S: ObjectV>: CollectionV<S> {
    override fun <K: ObjectV> new(common: () -> K): ListV<K>

    fun removeLast(): S = common().operation(removeLastListV(this))

    fun removeFirst(): S = common().operation(removeFirstListV(this))

    fun last(): S = common().operation(lastListV(this))

    fun first(): S = common().operation(firstListV(this))

    fun addToBegin(s: S): BooleanV = booleanV().operation(addToBeginListV(s, this))

    fun removeAll(s: CollectionV<S>): BooleanV = booleanV().operation(removeAllListV(s, this))

    override fun addAll_(l: Collection<S>): ListV<S> = super.addAll_(l) as ListV<S>

    override fun getInterfaceClass(): Class<*> = ListV::class.java

    fun accept(r: ListVisitor) {
        r.visit(this)
    }

    override fun accept(r: ObjectVisitor) {
        if (r is ListVisitor) {
            r.visit(this)
        } else {
            super.accept(r)
        }
    }

}



