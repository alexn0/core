/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.date

import com.opt2code.core.date.DateV_.Companion.dateV
import com.opt2code.core.obj.Data
import com.opt2code.core.obj.Data.Companion.notNullData
import com.opt2code.core.obj.PreObjectV
import com.opt2code.core.obj.PreObjectV_
import java.time.Instant
import java.time.LocalDate
import java.util.*

open class DateV_ private constructor(data: Data, o: PreObjectV = PreObjectV_.preObjectV(data)): PreObjectV by o, DateV {

    override fun new_(substitute: Boolean): DateV = DateV_(data_.copy(substitute = substitute))

    companion object {
        fun dateV(data: Data = Data()): DateV = DateV_(data)
    }
}

fun Date.V(): DateV = dateV(notNullData(this))

fun LocalDate.V(): DateV = dateV(notNullData(this))

fun Instant.V(): DateV = dateV(notNullData(this))