/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.obj.operation

import com.opt2code.core.bool.BooleanV
import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.operation.IfV_.Companion.ifV

fun <T: ObjectV> vIf(condition: BooleanV, block: () -> T): IfV<T> = ifV(condition, block())

