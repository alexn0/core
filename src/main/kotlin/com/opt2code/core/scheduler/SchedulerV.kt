/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.scheduler

import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.ObjectVisitor

interface SchedulerV: ObjectV {
    override fun getInterfaceClass(): Class<*> = SchedulerV::class.java

    fun accept(r: SchedulerVisitor) {
        r.visit(this)
    }

    override fun accept(r: ObjectVisitor) {
        if (r is SchedulerVisitor) {
            r.visit(this)
        } else {
            r.visit(this)
        }
    }

}

