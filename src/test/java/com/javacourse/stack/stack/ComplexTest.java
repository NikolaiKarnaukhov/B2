package com.javacourse.stack.stack;

import com.javacourse.stack.Stack;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Комплексные тесты функционала работы со стеком
 */
public interface ComplexTest extends IntegerStackProvider {

	@Test
	@DisplayName("комплексный тест работы со стеком")
	default void complexTest() {
		// Arrange
		Stack<Integer> stack = getIntegerStackImpl();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		// Act & assert
		assertThat(stack.peek()).isEqualTo(3);
		assertThat(stack.pop()).isEqualTo(3);
		assertThat(stack.peek()).isEqualTo(2);
		assertThat(stack.pop()).isEqualTo(2);
		assertThat(stack.peek()).isEqualTo(1);
		assertThat(stack.pop()).isEqualTo(1);
		// Empty stack assert
		assertThrows(RuntimeException.class, stack::pop);
	}

}
