/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.obj.operation

import com.opt2code.core.bool.BooleanV
import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.operation.WhileV_.Companion.whileV

fun <T: ObjectV> vWhile(condition: BooleanV, block: () -> T): WhileV<T> = whileV(condition, block())