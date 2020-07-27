/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.collection.collection

import com.opt2code.core.collection.CollectionV
import com.opt2code.core.obj.Data
import com.opt2code.core.obj.PreObjectV
import com.opt2code.core.obj.PreObjectV_

open class ClearV_ private constructor(
        override val first: CollectionV<*>,
        data: Data,
        o: PreObjectV = PreObjectV_.preObjectV(data)
): PreObjectV by o, ClearV {

    override fun new_(substitute: Boolean): ClearV = ClearV_(first, data_.copy(substitute = substitute))

    companion object {
        fun clearV(list: CollectionV<*>, data: Data = Data.data()): ClearV = ClearV_(list, data)
    }
}