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

class AddElementToCollectionV_<S: ObjectV> private constructor(
        override val second: S,
        override val first: CollectionV<S>,
        data: Data,
        o: PreObjectV = PreObjectV_.preObjectV(data)
): PreObjectV by o, AddElementToCollectionV<S> {

    override fun new_(substitute: Boolean): AddElementToCollectionV<S> = AddElementToCollectionV_(second, first, data_.copy(substitute = substitute))

    companion object {
        fun <S: ObjectV> addElementToCollectionV(arg: S, collection: CollectionV<S>, data: Data = Data.data()): AddElementToCollectionV<S> = AddElementToCollectionV_<S>(arg, collection, data)
    }
}