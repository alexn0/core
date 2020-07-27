/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.queue

import com.opt2code.core.list.ListV
import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.ObjectVisitor

import com.opt2code.core.obj.operation
import com.opt2code.core.queue.ElementFirstOperationV_.Companion.elementFirstOperationV
import com.opt2code.core.queue.ElementOperationV_.Companion.elementOperationV
import com.opt2code.core.queue.PeekFirstOperationV_.Companion.peekFirstOperationV
import com.opt2code.core.queue.PeekOperationV_.Companion.peekOperationV
import com.opt2code.core.queue.PollFirstOperationV_.Companion.pollFirstOperationV
import com.opt2code.core.queue.PollOperationV_.Companion.pollOperationV
import com.opt2code.core.queue.RemoveFirstQOperationV_.Companion.removeFirstQOperationV
import com.opt2code.core.queue.RemoveOperationV_.Companion.removeOperationV


interface QueueV<S: ObjectV>: ListV<S> {
    override fun <K: ObjectV> new(common: () -> K): QueueV<K>

    fun element(): S = common().operation(elementOperationV(this))

    fun remove(): S = common().operation(removeOperationV(this))

    fun poll(): S = common().operation(pollOperationV(this))

    fun peek(): S = common().operation(peekOperationV(this))

    fun elementFirst(): S = common().operation(elementFirstOperationV(this))

    override fun removeFirst(): S = common().operation(removeFirstQOperationV(this))

    fun pollFirst(): S = common().operation(pollFirstOperationV(this))

    fun peekFirst(): S = common().operation(peekFirstOperationV(this))

    override fun getInterfaceClass(): Class<*> = QueueV::class.java

    fun accept(r: QueueVisitor) {
        r.visit(this)
    }

    override fun accept(r: ObjectVisitor) {
        if (r is QueueVisitor) {
            r.visit(this)
        } else {
            super.accept(r)
        }
    }

}



