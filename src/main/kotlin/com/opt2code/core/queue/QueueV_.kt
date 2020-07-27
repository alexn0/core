/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.queue

import com.opt2code.core.cell.Wl
import com.opt2code.core.cell.Wl.Companion.wl
import com.opt2code.core.obj.Data
import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.PreObjectV
import com.opt2code.core.obj.PreObjectV_

open class QueueV_<S: ObjectV> private constructor(
        override val common: Wl<S>,
        val data: Data,
        o: PreObjectV = PreObjectV_.preObjectV(data)
): PreObjectV by o, QueueV<S> {

    override fun new_(substitute: Boolean): QueueV<S> = QueueV_(common, data_.copy(substitute = substitute))

    override fun <K: ObjectV> new(common: () -> K) = queueV(common, data)

    companion object {
        fun <S: ObjectV> queueV(common: () -> S, data: Data = Data.data()): QueueV<S> = QueueV_<S>(wl(common), data)
    }
}