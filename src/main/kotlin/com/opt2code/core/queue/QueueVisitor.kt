/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.queue

import com.opt2code.core.obj.ObjectV

interface QueueVisitor {
    fun <S: ObjectV> visit(vDate: QueueV<S>)
}