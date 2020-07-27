/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.list

import com.opt2code.core.obj.Data
import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.PreObjectV
import com.opt2code.core.obj.PreObjectV_

open class AddToBeginListV_<S: ObjectV> private constructor(
        override val arg: S,
        override val obj: ListV<S>,
        data: Data,
        o: PreObjectV = PreObjectV_.preObjectV(data)
): PreObjectV by o, AddToBeginListV<S> {

    override fun new_(substitute: Boolean): AddToBeginListV<S> = AddToBeginListV_(arg, obj, data_.copy(substitute = substitute))

    override fun elements(): List<ObjectV> = arrayListOf(obj, arg)

    companion object {
        fun <S: ObjectV> addToBeginListV(arg: S, obj: ListV<S>, data: Data = Data.data()): AddToBeginListV<S> = AddToBeginListV_<S>(arg, obj, data)
    }
}