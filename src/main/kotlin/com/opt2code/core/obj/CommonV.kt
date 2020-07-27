/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.obj


interface CommonV<T>: ObjectV {

    fun accept(r: CommonVisitor) {
        r.visit(this)
    }

    override fun accept(r: ObjectVisitor) {
        if (r is CommonVisitor) {
            r.visit(this)
        } else {
            r.visit(this)
        }
    }


    override fun getInterfaceClass(): Class<*> = CommonV::class.java
}

class CommonV_<T> private constructor(
        data: Data = Data(), o: PreObjectV = PreObjectV_.preObjectV(data)
): PreObjectV by o, CommonV<T> {

    override fun elements(): List<ObjectV> = emptyList()

    override fun new_(substitute: Boolean): CommonV<T> = commonV_(data_.copy(substitute = substitute))

    companion object {
        fun <T> commonV_(data: Data = Data(substitute = true)): CommonV<T> = CommonV_(data)

        fun <T> commonV(data: Data = Data(), t: () -> T): CommonV<T> = commonV_(data.copy(fixedValue = t))
    }
}

interface CommonVisitor {
    fun visit(o: CommonV<*>)
}
