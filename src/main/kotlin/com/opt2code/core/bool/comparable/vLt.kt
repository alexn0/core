/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.bool.comparable

import com.opt2code.core.bool.comparable.LtV_.Companion.ltV
import com.opt2code.core.obj.ComparableV

fun <T: ComparableV> T.vLt(second: T) = ltV(this, second)