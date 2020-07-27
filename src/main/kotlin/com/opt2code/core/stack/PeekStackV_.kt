/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.stack

import com.opt2code.core.obj.Data
import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.PreObjectV
import com.opt2code.core.obj.PreObjectV_

open class PeekStackV_<S: ObjectV> private constructor(
        override val obj: StackV<S>,
        data: Data,
        o: PreObjectV = PreObjectV_.preObjectV(data)
): PreObjectV by o, PeekStackV<S> {

    override fun new_(substitute: Boolean): PeekStackV<S> = PeekStackV_(obj, data_.copy(substitute = substitute))

    companion object {
        fun <S: ObjectV> peekStackV(obj: StackV<S>, data: Data = Data.data()): PeekStackV<S> = PeekStackV_<S>(obj, data)
    }
}