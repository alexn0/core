/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.collection

import com.opt2code.core.obj.ObjectV

interface CollectionVisitor {
    fun <S: ObjectV> visit(vFunction: CollectionV<S>)
}