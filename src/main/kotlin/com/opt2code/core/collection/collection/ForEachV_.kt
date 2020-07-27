/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.collection.collection

import com.opt2code.core.collection.CollectionV
import com.opt2code.core.function.consume.ConsumerV
import com.opt2code.core.function.consume.operation.InvokeConsumerV
import com.opt2code.core.obj.Data
import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.PreObjectV
import com.opt2code.core.obj.PreObjectV_

open class ForEachV_<S: ObjectV> private constructor(
        override val second: InvokeConsumerV<S>,
        override val first: CollectionV<S>,
        data: Data,
        o: PreObjectV = PreObjectV_.preObjectV(data)
): PreObjectV by o, ForEachV<S> {

    override fun new_(substitute: Boolean): ForEachV<S> = ForEachV_(second, first, data_.copy(substitute = substitute))

    companion object {
        fun <S: ObjectV> forEachV(arg: ConsumerV<S>, defaultArg: S, list: CollectionV<S>, data: Data = Data.data()): ForEachV<S> = ForEachV_(arg.invokeOperation(defaultArg), list, data)
    }
}