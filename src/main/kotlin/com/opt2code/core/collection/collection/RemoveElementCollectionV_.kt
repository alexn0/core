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

open class RemoveElementCollectionV_<S: ObjectV> private constructor(
        override val second: S,
        override val first: CollectionV<S>,
        data: Data,
        o: PreObjectV = PreObjectV_.preObjectV(data)
): PreObjectV by o, RemoveElementCollectionV<S> {

    override fun new_(substitute: Boolean): RemoveElementCollectionV<S> = RemoveElementCollectionV_(second, first, data_.copy(substitute = substitute))

    companion object {
        fun <S: ObjectV> removeElementCollectionV(arg: S, obj: CollectionV<S>, data: Data = Data.data()): RemoveElementCollectionV<S> = RemoveElementCollectionV_<S>(arg, obj, data)
    }
}