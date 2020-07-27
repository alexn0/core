/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core

inline fun <reified T: Any> jClass(): Class<T> = T::class.java