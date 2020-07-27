/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.function.consume

import com.opt2code.core.obj.ObjectV

interface ConsumerVisitor {
    fun <T: ObjectV> visit(vFunction: ConsumerV<T>)
}