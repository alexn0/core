/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.obj

import com.opt2code.core.persistence.SQLObjectV

class ObjectV_ private constructor(o: PreObjectV): PreObjectV by o, ObjectV, SQLObjectV {

    override fun new_(substitute: Boolean): ObjectV = objectV(data_.copy(substitute = substitute))

    override fun getInterfaceClass(): Class<*> = ObjectV::class.java

    companion object {
        fun objectV_(data: Data = Data(substitute = true)): ObjectV = ObjectV_(PreObjectV_.preObjectV(data))

        fun objectV(data: Data = Data()): ObjectV = ObjectV_(PreObjectV_.preObjectV(data))
    }
}