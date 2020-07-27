/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.stack

import com.opt2code.core.obj.Data
import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.PreObjectV
import com.opt2code.core.obj.PreObjectV_

open class SearchStackV_<S: ObjectV> private constructor(
        override val arg: S,
        override val obj: StackV<S>,
        data: Data,
        o: PreObjectV = PreObjectV_.preObjectV(data)
): PreObjectV by o, SearchStackV<S> {

    override fun new_(substitute: Boolean): SearchStackV<S> = SearchStackV_(arg, obj, data_.copy(substitute = substitute))

    companion object {
        fun <S: ObjectV> searchStackV(arg: S, obj: StackV<S>, data: Data = Data.data()): SearchStackV<S> = SearchStackV_<S>(arg, obj, data)
    }
}