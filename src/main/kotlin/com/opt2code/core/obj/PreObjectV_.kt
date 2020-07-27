/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.obj

class PreObjectV_ private constructor(val fixed: Boolean,
                                      val fixedValue: Any?,
                                      isNullable: Boolean,
                                      override var argInfo: ArgParam,
                                      override val data_: Data): PreObjectExtV {
    override fun elements(): List<ObjectV> = ArrayList()

    override var el_: List<ObjectV>? = null

    override fun addOperation(object_: ObjectV) {
        operations.add(object_)
    }

    private val operations: MutableList<ObjectV> = ArrayList()

    override fun operations(): List<ObjectV> = operations

    override fun isFixed(): Boolean = fixed

    override fun fixedValue(): Any? = fixedValue

    override fun isOrdering(): Boolean = data_.ordering

    override var isNullable: Boolean = if (isFixed() && fixedValue == null) true else isNullable

    companion object {
        fun preObjectV(
                data: Data = Data()
        ): PreObjectV = PreObjectV_(data.fixed, data.fixedValue, data.isNullable, data.argInfo, data)
    }
}



