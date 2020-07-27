/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.string

import com.opt2code.core.obj.Data
import com.opt2code.core.obj.Data.Companion.notNullData
import com.opt2code.core.obj.PreObjectV
import com.opt2code.core.obj.PreObjectV_
import com.opt2code.core.string.StringV_.Companion.stringV

class StringV_ private constructor(data: Data = Data(), o: PreObjectV = PreObjectV_.preObjectV(data)): PreObjectV by o, StringV {

    override fun new_(substitute: Boolean): StringV = StringV_(data_.copy(substitute = substitute))

    companion object {
        fun stringV(data: Data = Data()): StringV = StringV_(data)

    }
}

fun String.V(): StringV = stringV(notNullData(this))

fun StringBuffer.V(): StringV = stringV(notNullData(this))

fun StringBuilder.V(): StringV = stringV(notNullData(this))