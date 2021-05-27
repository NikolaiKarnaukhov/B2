package com.javacourse.stack;

/**
 * Реализация стека при помощи массива элементов
 */
public class ArrayStack<ItemTypeT> implements Stack<ItemTypeT> {

	private int arraySize = 0;
	private Object[] stackArray;
	private int head;
	private int difference = 10;

	public ArrayStack(){
		stackArray = new Object[arraySize];
		head = -1;
	}
	@Override
	public void push(ItemTypeT item) {
		if(head == -1){
			arraySize++;
			stackArray = new Object[arraySize];
		}
		if(head !=arraySize -1){
			head++;
			stackArray[head] = item;
		}
		else{
			head++;
			arraySize = arraySize+difference;
			Object[] newArray = new Object[arraySize];
			System.arraycopy(stackArray,0,newArray,0,arraySize - difference);
			stackArray = null;
			newArray[head] = item;
			stackArray = newArray;
		}
	}

	@Override
	public ItemTypeT pop() {
		if(head == -1){
			throw  new RuntimeException("Empty Stack Exception");
		}
		if(head ==0){
			arraySize--;
			head--;
			Object temp = stackArray[0];
			stackArray = null;
			return (ItemTypeT) temp;
		}
		else{
			Object temp = stackArray[head];
			head--;

			if(arraySize % difference == 0){
				arraySize--;
				Object[] newArray = new Object[arraySize];
				System.arraycopy(stackArray,0,newArray, 0,arraySize);
				stackArray = null;
				stackArray = newArray;
				return (ItemTypeT) temp;
			}
			else{
				arraySize--;
				return  (ItemTypeT) temp;
			}
		}
	}

	@Override
	public ItemTypeT peek() {
		if(head != -1) {return (ItemTypeT) stackArray[head];}
		else throw new RuntimeException("Empty Stack Exception");
	}
}
