/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.collection.collection

import com.opt2code.core.collection.CollectionV
import com.opt2code.core.obj.Data
import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.PreObjectV
import com.opt2code.core.obj.PreObjectV_

open class IsEmptyCollectionV_ private constructor(
        override val first: CollectionV<out ObjectV>,
        data: Data,
        o: PreObjectV = PreObjectV_.preObjectV(data)
): PreObjectV by o, IsEmptyCollectionV {

    override fun new_(substitute: Boolean): IsEmptyCollectionV = IsEmptyCollectionV_(first, data_.copy(substitute = substitute))

    companion object {
        fun isEmptyCollectionV(obj: CollectionV<out ObjectV>, data: Data = Data.data()): IsEmptyCollectionV = IsEmptyCollectionV_(obj, data)
    }
}