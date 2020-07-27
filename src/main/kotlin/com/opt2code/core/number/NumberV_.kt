/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.number

import com.opt2code.core.number.NumberV_.Companion.numberV
import com.opt2code.core.obj.Data
import com.opt2code.core.obj.PreObjectV
import com.opt2code.core.obj.PreObjectV_.Companion.preObjectV
import java.math.BigDecimal
import java.math.BigInteger

open class NumberV_ private constructor(data: Data = Data(), o: PreObjectV = preObjectV(data)): PreObjectV by o, NumberV {
    override fun new_(substitute: Boolean): NumberV = NumberV_(data_.copy(substitute = substitute))

    companion object {
        fun numberV(data: Data = Data()): NumberV = NumberV_(data)
    }
}


fun Int.V() = numberV(Data.notNullData(this))

fun Long.V() = numberV(Data.notNullData(this))

fun Double.V() = numberV(Data.notNullData(this))

fun BigDecimal.V() = numberV(Data.notNullData(this))

fun BigInteger.V() = numberV(Data.notNullData(this))

fun Short.V() = numberV(Data.notNullData(this))

fun Byte.V() = numberV(Data.notNullData(this))

fun Float.V() = numberV(Data.notNullData(this))