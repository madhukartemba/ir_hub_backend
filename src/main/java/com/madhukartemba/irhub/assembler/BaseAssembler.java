package com.madhukartemba.irhub.assembler;

public interface BaseAssembler<T, V> {

    public V toModel(T entity);
}
