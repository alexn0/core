/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.number

import com.opt2code.core.number.number.DivNumberV
import com.opt2code.core.number.number.DivNumberV_.Companion.divNumberV
import com.opt2code.core.number.number.MinusNumberV
import com.opt2code.core.number.number.MinusNumberV_.Companion.minusNumberV
import com.opt2code.core.number.number.PlusNumberV
import com.opt2code.core.number.number.PlusNumberV_.Companion.plusNumberV
import com.opt2code.core.number.number.RemNumberV
import com.opt2code.core.number.number.RemNumberV_.Companion.remNumberV
import com.opt2code.core.number.number.TimesNumberV
import com.opt2code.core.number.number.TimesNumberV_.Companion.timesNumberV
import com.opt2code.core.obj.ComparableV
import com.opt2code.core.obj.ObjectVisitor
import com.opt2code.core.persistence.SQLPrimitiveV

interface NumberV: ComparableV, SQLPrimitiveV {

    fun accept(r: NumberVisitor) {
        r.visit(this)
    }

    override fun accept(r: ObjectVisitor) {
        if (r is NumberVisitor) {
            r.visit(this)
        } else {
            r.visit(this)
        }
    }

    operator fun plus(increment: NumberV): PlusNumberV = plusNumberV(this, increment)
    operator fun minus(increment: NumberV): MinusNumberV = minusNumberV(this, increment)
    operator fun times(increment: NumberV): TimesNumberV = timesNumberV(this, increment)
    operator fun div(increment: NumberV): DivNumberV = divNumberV(this, increment)
    operator fun rem(increment: NumberV): RemNumberV = remNumberV(this, increment)

    override fun getInterfaceClass(): Class<*> = NumberV::class.java
}