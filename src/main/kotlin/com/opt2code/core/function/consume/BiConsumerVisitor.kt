/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.function.consume

import com.opt2code.core.obj.ObjectV

interface BiConsumerVisitor {
    fun <T: ObjectV, S: ObjectV> visit(vFunction: BiConsumerV<T, S>)
}