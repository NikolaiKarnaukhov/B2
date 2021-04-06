package com.javacourse.stack.stack;

import com.javacourse.stack.Stack;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Тесты для проверки метода peek()
 */
public interface PeekStackTest extends IntegerStackProvider {

	@Test
	@DisplayName("peek() всегда вытаскивает последний элемент")
	default void peekTheSameElemWhenNothingGetFromStack() {
		Stack<Integer> stack = getIntegerStackImpl();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		assertThat(stack.peek()).isEqualTo(3);
		assertThat(stack.peek()).isEqualTo(3);
		assertThat(stack.peek()).isEqualTo(3);
	}

	@Test
	@DisplayName("peek() не влияет на содержание стека")
	default void popAfterPeek() {
		Stack<Integer> stack = getIntegerStackImpl();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		// Act
		stack.peek();
		stack.peek();
		stack.peek();
		// Assert
		assertThat(stack.pop()).isEqualTo(3);
		assertThat(stack.pop()).isEqualTo(2);
		assertThat(stack.pop()).isEqualTo(1);
		assertThrows(RuntimeException.class, stack::peek);
	}

	@Test
	@DisplayName("peek() на пустом стэке приведет к исключению")
	default void peekFromEmptyStack() {
		Stack<Integer> stack = getIntegerStackImpl();
		RuntimeException exc = assertThrows(RuntimeException.class, stack::peek);
		assertThat(exc).hasMessage("Empty Stack Exception");
	}

	@Test
	@DisplayName("peek() возвращает последний элемент, каждый раз после сдвига стэка")
	default void peekAfterPop() {
		Stack<Integer> stack = getIntegerStackImpl();

		stack.push(1);
		assertThat(stack.peek()).isEqualTo(1);

		stack.push(2);
		assertThat(stack.peek()).isEqualTo(2);

		stack.push(3);
		assertThat(stack.peek()).isEqualTo(3);

		stack.pop();
		assertThat(stack.peek()).isEqualTo(2);

		stack.pop();
		assertThat(stack.peek()).isEqualTo(1);
	}
}
