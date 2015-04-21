package com.finco.framework.search;

public interface IFunctor<T> {
	public void compute(T input);
	public T getValue();
}
