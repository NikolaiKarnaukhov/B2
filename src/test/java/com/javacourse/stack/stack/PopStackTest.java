package com.javacourse.stack.stack;

import com.javacourse.stack.Stack;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Тесты для проверки метода pop()
 */
public interface PopStackTest extends IntegerStackProvider {

	@Test
	@DisplayName("pop() из пустого стэка приводит к исключению")
	default void popFromEmptyStack() {
		Stack<Integer> stack = getIntegerStackImpl();
		RuntimeException exc = assertThrows(RuntimeException.class, stack::pop);
		assertThat(exc).hasMessage("Empty Stack Exception");
	}

	@Test
	@DisplayName("pop() достает один элемент из стека")
	default void singlePushAndPop() {
		Stack<Integer> stack = getIntegerStackImpl();
		stack.push(123);
		assertThat(stack.pop()).isEqualTo(123);
		assertThrows(RuntimeException.class, stack::pop);
	}

	@Test
	@DisplayName("pop() достает все элементы стэка в обратной последовательности")
	default void popMultipleItems() {
		Stack<Integer> stack = getIntegerStackImpl();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		assertThat(stack.pop()).isEqualTo(3);
		assertThat(stack.pop()).isEqualTo(2);
		assertThat(stack.pop()).isEqualTo(1);
	}
}
