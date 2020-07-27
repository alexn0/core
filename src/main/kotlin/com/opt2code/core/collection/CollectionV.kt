/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.collection

import com.opt2code.core.bool.BooleanV
import com.opt2code.core.bool.BooleanV_.Companion.booleanV
import com.opt2code.core.cell.CellV
import com.opt2code.core.collection.collection.AddAllToCollectionV_.Companion.addAllToCollectionV
import com.opt2code.core.collection.collection.AddElementToCollectionV_.Companion.addElementToCollectionV
import com.opt2code.core.collection.collection.ClearV
import com.opt2code.core.collection.collection.ClearV_.Companion.clearV
import com.opt2code.core.collection.collection.CollectionMappingV_.Companion.collectionMappingV
import com.opt2code.core.collection.collection.ContainsOperationCollectionV_.Companion.containsOperationCollectionV
import com.opt2code.core.collection.collection.FilterV_.Companion.filterV
import com.opt2code.core.collection.collection.ForEachV_.Companion.forEachV
import com.opt2code.core.collection.collection.IsEmptyCollectionV_.Companion.isEmptyCollectionV
import com.opt2code.core.collection.collection.RemoveElementCollectionV_.Companion.removeElementCollectionV
import com.opt2code.core.function.consume.ConsumerV
import com.opt2code.core.function.function.FunctionV
import com.opt2code.core.function.predicate.PredicateV
import com.opt2code.core.obj.ObjectV
import com.opt2code.core.obj.ObjectVisitor
import com.opt2code.core.obj.newOperation
import com.opt2code.core.obj.operation
import com.opt2code.core.obj.pv


interface CollectionV<S: ObjectV>: ObjectV {
    val common: CellV<S>

    fun <K: ObjectV> new(common: () -> K): CollectionV<K>

    fun <T: ObjectV> map(f: FunctionV<S, T>) = new({ f(common()) }).operation(collectionMappingV(f, common(), this))

    fun clear(): ClearV = newOperation(clearV(this))

    fun isEmpty(): BooleanV = booleanV().operation(isEmptyCollectionV(this))

    fun removeElement(s: S): BooleanV = booleanV().operation(removeElementCollectionV(s, this))

    fun add(s: S): BooleanV = booleanV().operation(addElementToCollectionV(s, this))

    fun add(s: () -> S): BooleanV = add(s())

    fun addAll(l: CollectionV<S>): CollectionV<S> = pv { addAllToCollectionV(l, this) }

    fun addAll_(l: Collection<S>): CollectionV<S> = this.let {
        var result = it
        l.forEach {
            result = result.pv {
                result.add(it)
            }
        }
        result
    }

    fun contains(s: S): BooleanV = booleanV().operation(containsOperationCollectionV(s, this))

    override fun getInterfaceClass(): Class<*> = CollectionV::class.java

    fun accept(r: CollectionVisitor) {
        r.visit(this)
    }

    override fun accept(r: ObjectVisitor) {
        if (r is CollectionVisitor) {
            r.visit(this)
        } else {
            r.visit(this)
        }
    }

}

fun <S: ObjectV, U: CollectionV<S>> U.toSubCollectionV(f: PredicateV<S>): U =
        (new({ common() }) as U).also { it.operation(filterV(f, common(), this, it)) }

fun <S: ObjectV, U: CollectionV<S>> U.removeByFilterV(f: PredicateV<S>): U {
    return this.operation(filterV(f, common(), this, this))
}

fun <S: ObjectV, U: CollectionV<S>> U.forEachV(f: ConsumerV<S>): U {
    return this.operation(forEachV(f, common(), this))
}