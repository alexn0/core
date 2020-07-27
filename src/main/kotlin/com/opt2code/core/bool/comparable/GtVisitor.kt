/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.bool.comparable

import com.opt2code.core.obj.ComparableV

interface GtVisitor {
    fun <T: ComparableV> visit(vBoolean: GtV<T>)
}