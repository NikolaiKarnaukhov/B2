package com.javacourse.stack.stack;

import com.javacourse.stack.Stack;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Тесты для проверки метода push()
 */
public interface PushStackTest extends IntegerStackProvider {

	@Test
	@DisplayName("push() может добавить null-value")
	default void pushNullValue() {
		Stack<Integer> stack = getIntegerStackImpl();
		stack.push(1);
		stack.push(2);
		stack.push(null);
		stack.push(3);
		assertThat(stack.pop()).isEqualTo(3);
		assertThat(stack.pop()).isEqualTo(null);
		assertThat(stack.pop()).isEqualTo(2);
		assertThat(stack.pop()).isEqualTo(1);
		assertThrows(RuntimeException.class, stack::pop);
	}


	@Test
	@DisplayName("push() сохраняет каждый добавленный элемент, даже если такой уже был добавлен ранее")
	default void pushEqualsItems() {
		Stack<Integer> stack = getIntegerStackImpl();
		stack.push(1);
		stack.push(1);
		stack.push(1);
		assertThat(stack.pop()).isEqualTo(1);
		assertThat(stack.pop()).isEqualTo(1);
		assertThat(stack.pop()).isEqualTo(1);
		assertThrows(RuntimeException.class, stack::pop);
	}

	@Test
	@DisplayName("push() сохраняет элементы в том порядке, в котором их добавляли")
	default void pushOrdering() {
		Stack<Integer> stack = getIntegerStackImpl();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		assertThat(stack.pop()).isEqualTo(3);
		assertThat(stack.pop()).isEqualTo(2);
		assertThat(stack.pop()).isEqualTo(1);
	}
}
