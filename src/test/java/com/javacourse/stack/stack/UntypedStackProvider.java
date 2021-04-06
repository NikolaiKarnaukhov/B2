package com.javacourse.stack.stack;

import com.javacourse.stack.Stack;

/**
 * возвращает нетипизированный стек
 */
public interface UntypedStackProvider {

	@SuppressWarnings("rawtypes")
	Stack getUntypedStack();
}
