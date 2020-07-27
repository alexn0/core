/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.collection


import com.opt2code.core.cell.Wl.Companion.wl
import com.opt2code.core.obj.Data
import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.PreObjectV
import com.opt2code.core.obj.PreObjectV_

class CollectionV_<S: ObjectV> private constructor(
        common: () -> S,
        val data: Data = Data(),
        o: PreObjectV = PreObjectV_.preObjectV(data)
): PreObjectV by o, CollectionV<S> {

    override fun new_(substitute: Boolean): CollectionV<S> = CollectionV_({ common() }, data_.copy(substitute = substitute))

    override val common = wl(common)

    override fun <K: ObjectV> new(common: () -> K) = collectionV(common, data)

    companion object {
        fun <S: ObjectV> collectionV(common: () -> S, data: Data = Data()): CollectionV<S> = CollectionV_(common, data)
    }
}