/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.obj


data class Data(
        val fixed: Boolean = false,
        val fixedValue: Any? = null,
        val isNullable: Boolean = false,
        val ordering: Boolean = false,
        val substitute: Boolean = false,
        val forceFormulaType: ExtFormulaType? = null,
        val isUseMetadataInsteadCalculatedValue: Boolean = false,
        val isFramework: Boolean = false,
        internal val argInfo: ArgParam = ArgParam(),
        private val isSingleton: Boolean = false
) {
    fun toReplacement(substitute: Boolean) = if (substitute) this.copy(substitute = substitute) else this.copy()

    fun isSingleton(): Boolean = isSingleton && !substitute

    companion object {

        fun data(fixed: Boolean = false,
                 fixedValue: Any? = null,
                 isNullable: Boolean = false,
                 ordering: Boolean = false,
                 substitute: Boolean = false,
                 forceFormulaType: ExtFormulaType? = null,
                 isUseMetadataInsteadCalculatedValue: Boolean = false,
                 isFramework: Boolean = false,
                 argInfo: ArgParam = ArgParam(),
                 isSingleton: Boolean = false): Data = Data(fixed, fixedValue, isNullable, ordering, substitute, forceFormulaType, isUseMetadataInsteadCalculatedValue, isFramework, argInfo, isSingleton)

        fun nullData() = data(true, null, true)

        fun nullableData(fixedValue: Any?) = data(true, fixedValue, true)

        fun notNullData(fixedValue: Any) = data(true, fixedValue, false)

    }

}