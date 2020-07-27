/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.list

import com.opt2code.core.collection.CollectionV
import com.opt2code.core.obj.Data
import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.PreObjectV
import com.opt2code.core.obj.PreObjectV_

open class RemoveAllListV_<S: ObjectV> private constructor(
        override val arg: CollectionV<S>,
        override val obj: ListV<S>,
        data: Data,
        o: PreObjectV = PreObjectV_.preObjectV(data)
): PreObjectV by o, RemoveAllListV<S> {

    override fun new_(substitute: Boolean): RemoveAllListV<S> = RemoveAllListV_(arg, obj, data_.copy(substitute = substitute))

    companion object {
        fun <S: ObjectV> removeAllListV(arg: CollectionV<S>, obj: ListV<S>, data: Data = Data.data()): RemoveAllListV<S> = RemoveAllListV_<S>(arg, obj, data)
    }
}