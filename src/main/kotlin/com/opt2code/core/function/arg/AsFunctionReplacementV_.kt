/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.function.arg

import com.opt2code.core.obj.Data
import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.PreObjectV
import com.opt2code.core.obj.PreObjectV_

class AsFunctionReplacementV_ private constructor(
        val func: ObjectV,
        var args: List<ObjectV>,
        data: Data,
        o: PreObjectV = PreObjectV_.preObjectV(data)
): PreObjectV by o, AsFunctionReplacementV {

    override fun new_(substitute: Boolean): AsFunctionReplacementV = AsFunctionReplacementV_(func, args, data_.copy(substitute = substitute))

    override fun elements(): List<ObjectV> = arrayListOf(func) + args

    companion object {
        fun asFunctionReplacementV(asFunc: AsFunctionV<*>, data: Data = Data.data()): AsFunctionReplacementV = AsFunctionReplacementV_(asFunc.hiddenMainElement(), args = asFunc.hiddenElements(), data = data)
    }
}


