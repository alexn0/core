/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.list

import com.opt2code.core.obj.Data
import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.PreObjectV
import com.opt2code.core.obj.PreObjectV_

open class RemoveFirstListV_<S: ObjectV> private constructor(
        override val obj: ListV<S>,
        data: Data,
        o: PreObjectV = PreObjectV_.preObjectV(data)
): PreObjectV by o, RemoveFirstListV<S> {

    override fun new_(substitute: Boolean): RemoveFirstListV<S> = RemoveFirstListV_(obj, data_.copy(substitute = substitute))

    companion object {
        fun <S: ObjectV> removeFirstListV(obj: ListV<S>, data: Data = Data.data()): RemoveFirstListV<S> = RemoveFirstListV_<S>(obj, data)
    }
}