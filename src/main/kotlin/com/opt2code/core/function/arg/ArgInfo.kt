/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.function.arg


class ArgInfo(val sizes: List<Int>,
              val args: List<WrapperArgValue>,
              val size: Int) {


    fun <T> calculate(func: (List<WrapperArgValue>) -> T): Any? {
        var res: Any? = func
        var currentSize = size
        if (currentSize <= 0) {
            return func.invoke(emptyList())
        }
        for (k in args.size downTo 1) {
            res = compose(res, args[k - 1].v, k, sizes[k - 1], currentSize)
            currentSize = getComposeSize(currentSize, sizes[k - 1])
        }
        return res
    }

    fun compose(
            f: Any?,
            g: Any?,
            k: Int,
            gSize: Int,
            fSize: Int
    ): Any? {
        val newSize = getComposeSize(fSize, gSize)
        val fnc = f as (List<WrapperArgValue>) -> Any?
        return { arg: List<WrapperArgValue> ->
            val res = ArrayList<WrapperArgValue>()

            val min: Int = Math.min(k - 1, newSize)

            if (min > 0) {
                res.addAll(arg.subList(0, min))
            }

            if (gSize >= 0) {
                val gnc = g as (List<WrapperArgValue>) -> Any?
                res.add(WrapperArgValue(gnc(arg.subList(k - 1, k - 1 + gSize))))
            } else {
                res.add(WrapperArgValue(g))
            }

            if (k < fSize) {
                val startingIndex = if (gSize >= 0) {
                    k - 1 + gSize
                } else {
                    k + gSize
                }
                res.addAll(arg.subList(startingIndex, newSize))
            }
            if (gSize == 0) {
                { fnc(res) }
            } else {
                fnc(res)
            }
        }.run {
            if (newSize >= 0) {
                this
            } else {
                this.invoke(emptyList())
            }
        }
    }

    fun getComposeSize(fSize: Int, gSize: Int): Int {
        return if (fSize + gSize >= 0) {
            if (gSize >= 0) {
                fSize + gSize - 1
            } else if (fSize > 1) {
                fSize + gSize
            } else {
                -1
            }
        } else {
            -1
        }
    }
}