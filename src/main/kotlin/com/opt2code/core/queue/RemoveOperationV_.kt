/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.queue

import com.opt2code.core.obj.Data
import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.PreObjectV
import com.opt2code.core.obj.PreObjectV_

open class RemoveOperationV_<S: ObjectV> private constructor(
        override val obj: QueueV<S>,
        data: Data,
        o: PreObjectV = PreObjectV_.preObjectV(data)
): PreObjectV by o, RemoveOperationV<S> {

    override fun new_(substitute: Boolean): RemoveOperationV<S> = RemoveOperationV_(obj, data_.copy(substitute = substitute))

    companion object {
        fun <S: ObjectV> removeOperationV(obj: QueueV<S>, data: Data = Data.data()): RemoveOperationV<S> = RemoveOperationV_<S>(obj, data)
    }
}