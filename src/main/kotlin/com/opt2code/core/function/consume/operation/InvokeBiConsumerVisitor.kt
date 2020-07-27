/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.function.consume.operation

import com.opt2code.core.obj.ObjectV

interface InvokeBiConsumerVisitor {
    fun <S: ObjectV, T: ObjectV> visit(vDate: InvokeBiConsumerV<S, T>)
}