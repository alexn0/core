/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.scheduler

import com.opt2code.core.obj.Data
import com.opt2code.core.obj.PreObjectV
import com.opt2code.core.obj.PreObjectV_

open class SchedulerV_ private constructor(
        data: Data,
        o: PreObjectV = PreObjectV_.preObjectV(data)
): PreObjectV by o, SchedulerV {

    override fun new_(substitute: Boolean): SchedulerV = SchedulerV_(data_.copy(substitute = substitute))

    companion object {
        fun schedulerV(data: Data = Data.data()): SchedulerV = SchedulerV_(data)
    }
}