/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.function.consume.operation

import com.opt2code.core.obj.ObjectV

interface InvokeConsumerVisitor {
    fun <T: ObjectV> visit(vDate: InvokeConsumerV<T>)
}

