/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.bool.comparable

import com.opt2code.core.bool.comparable.GtOrEqV_.Companion.gtOrEqV
import com.opt2code.core.obj.ComparableV

fun <T: ComparableV> T.vGtOrEq(second: T) = gtOrEqV(this, second)