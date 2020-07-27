/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.bool.comparable

import com.opt2code.core.bool.comparable.GtV_.Companion.gtV
import com.opt2code.core.obj.ComparableV

fun <T: ComparableV> T.vGt(second: T) = gtV(this, second)