package com.javacourse.stack.stack;

import com.javacourse.stack.Stack;

/**
 * интерфейс для получения целочисленной реализации стека
 */
public interface IntegerStackProvider {

	Stack<Integer> getIntegerStackImpl();
}
