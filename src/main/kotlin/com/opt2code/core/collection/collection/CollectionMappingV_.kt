/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.collection.collection

import com.opt2code.core.collection.CollectionV
import com.opt2code.core.function.function.FunctionV
import com.opt2code.core.function.function.operation.InvokeFunctionV
import com.opt2code.core.obj.Data
import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.PreObjectV
import com.opt2code.core.obj.PreObjectV_

open class CollectionMappingV_<S: ObjectV, T: ObjectV> private constructor(
        override val third: InvokeFunctionV<S, T>,
        override val second: S,
        override val first: CollectionV<S>,
        data: Data,
        o: PreObjectV = PreObjectV_.preObjectV(data)
): PreObjectV by o, CollectionMappingV<S, T> {

    override fun new_(substitute: Boolean): CollectionMappingV<S, T> = CollectionMappingV_(third, second, first, data_.copy(substitute = substitute))

    companion object {
        fun <S: ObjectV, T: ObjectV> collectionMappingV(arg: FunctionV<S, T>, defaultArg: S, collection: CollectionV<S>, data: Data = Data.data()): CollectionMappingV<S, T> = CollectionMappingV_<S, T>(arg.invokeOperation(defaultArg), defaultArg, collection, data)
    }
}