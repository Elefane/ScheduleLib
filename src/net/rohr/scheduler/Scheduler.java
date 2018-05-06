package net.rohr.scheduler;

public class Scheduler {

	private Operand firstOperand;
	private Operand currentOperand;
	private Operand lastOperand;

	public Scheduler(){

	}

	public Operand createOperand(int lockType, String transactionName, String accessedVariable){
		return new Operand(lockType, transactionName, accessedVariable);
	}

	public void reset(){
		firstOperand = null;
		currentOperand = null;
		lastOperand = null;
	}

	public void appendOperand(Operand operand){
		if(firstOperand == null){
			createFirstOperand(operand);
		} else {
			createLastOperand(operand);
		}
	}

	private void createFirstOperand(Operand operand){
		firstOperand = operand;
		currentOperand = operand;
		lastOperand = operand;
	}

	private void createLastOperand(Operand operand){
		lastOperand.setNextOperand(operand);
		operand.setPreviousOperand(lastOperand);
		lastOperand = operand;
	}

	private void prependFirstOperand(Operand operand){
		if (firstOperand == null) {
			createFirstOperand(operand);
		} else {
			firstOperand.setPreviousOperand(operand);
			operand.setNextOperand(firstOperand);
			firstOperand = operand;
		}
	}

	public void insertBeforeCurrent(Operand operand){
		if(currentOperand == null){
			appendOperand(operand);
			currentOperand = operand;
		} else {
			if (currentOperand == firstOperand){
				prependFirstOperand(operand);
			} else {
				Operand previousOperand = currentOperand.getPreviousOperand();
				previousOperand.setNextOperand(operand);
				currentOperand.setPreviousOperand(operand);
			}
		}
	}

	public void insertAfterCurrent(Operand operand){
		if(currentOperand == null){
			appendOperand(operand);
			currentOperand = operand;
		} else {
			if (currentOperand == lastOperand){
				createLastOperand(operand);
			} else {
				Operand nextOperand = currentOperand.getNextOperand();
				nextOperand.setPreviousOperand(operand);
				currentOperand.setNextOperand(operand);
			}
		}
	}

	public Operand next(){
		if(currentOperand == null){
			currentOperand = first();
		} else {
			currentOperand = currentOperand.getNextOperand();
		}
		return currentOperand;
	}

	public Operand previous(){
		if(currentOperand == null){
			currentOperand = first();
		} else {
			currentOperand = currentOperand.getPreviousOperand();
		}
		return currentOperand;
	}

	public Operand first(){
		return firstOperand;
	}

	public Operand last(){
		return lastOperand;
	}

	public Operand current(){
		return currentOperand;
	}
}
