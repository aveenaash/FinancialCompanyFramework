package com.finco.framework.search;

public interface IPredicate<T> {
	public boolean check(T input);
}
