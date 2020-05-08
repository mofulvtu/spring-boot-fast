package com.liuzg.base;

@FunctionalInterface
interface Converter<F, T> {
    T convert(F from);
}