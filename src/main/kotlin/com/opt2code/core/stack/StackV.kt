/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.stack

import com.opt2code.core.collection.CollectionV
import com.opt2code.core.number.NumberV
import com.opt2code.core.number.NumberV_.Companion.numberV

import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.ObjectVisitor
import com.opt2code.core.obj.operation
import com.opt2code.core.stack.PeekStackV_.Companion.peekStackV
import com.opt2code.core.stack.PopStackV_.Companion.popStackV
import com.opt2code.core.stack.PushStackV_.Companion.pushStackV
import com.opt2code.core.stack.SearchStackV_.Companion.searchStackV


interface StackV<S: ObjectV>: CollectionV<S> {
    override fun <K: ObjectV> new(common: () -> K): StackV<K>

    fun peek(): S = common().operation(peekStackV(this))

    fun pop(): S = common().operation(popStackV(this))

    fun push(t: S): S = common().operation(pushStackV(t, this))

    fun search(t: S): NumberV = numberV().operation(searchStackV(t, this))

    override fun getInterfaceClass(): Class<*> = StackV::class.java

    fun accept(r: StackVisitor) {
        r.visit(this)
    }

    override fun accept(r: ObjectVisitor) {
        if (r is StackVisitor) {
            r.visit(this)
        } else {
            super.accept(r)
        }
    }


}



