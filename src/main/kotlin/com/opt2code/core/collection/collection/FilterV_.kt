/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.collection.collection

import com.opt2code.core.bool.BooleanV
import com.opt2code.core.collection.CollectionV
import com.opt2code.core.function.function.operation.InvokeFunctionV
import com.opt2code.core.function.predicate.PredicateV
import com.opt2code.core.obj.Data
import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.PreObjectV
import com.opt2code.core.obj.PreObjectV_

open class FilterV_<S: ObjectV> private constructor(
        override val third: InvokeFunctionV<S, BooleanV>,
        override val fourth: S,
        override val first: CollectionV<S>,
        override val second: CollectionV<S>,
        data: Data,
        o: PreObjectV = PreObjectV_.preObjectV(data)
): PreObjectV by o, FilterV<S> {

    override fun new_(substitute: Boolean): FilterV<S> = FilterV_(third, fourth, first, second, data_.copy(substitute = substitute))

    companion object {
        fun <S: ObjectV> filterV(arg: PredicateV<S>, defaultArg: S, list: CollectionV<S>, to: CollectionV<S>, data: Data = Data.data()): FilterV<S> = FilterV_<S>(arg.invokeOperation(defaultArg), defaultArg, list, to, data)
    }
}