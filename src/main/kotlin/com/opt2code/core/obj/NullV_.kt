/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.obj

class NullV_ private constructor(
        data: Data = Data(), o: PreObjectV = PreObjectV_.preObjectV(data)
): PreObjectV by o, NullV {

    override fun elements(): List<ObjectV> = arrayListOf(ObjectV_.objectV())

    override fun new_(substitute: Boolean): NullV = nullV_(data_.copy(substitute = substitute))

    companion object {
        fun nullV_(data: Data = Data(substitute = true)): NullV = NullV_(data)

        fun nullV(data: Data = Data(fixed = true)): NullV = nullV_(data)
    }
}