package net.rohr.scheduler;

public class Operand {

	private int lockType;
	private String transactionName;
	private String accessedVariable;

	private Operand previousOperand;
	private Operand nextOperand;

	public Operand(int lockType, String transactionName, String accessedVariable){
		this.setLockType(lockType);
		this.setTransactionName(transactionName);
		this.setAccessedVariable(accessedVariable);
		this.previousOperand = null;
		this.nextOperand = null;
	}

	/**
	 * @return the lockType
	 */
	public int getLockType() {
		return lockType;
	}

	/**
	 * @param lockType the lockType to set
	 */
	public void setLockType(int lockType) {
		this.lockType = lockType;
	}

	/**
	 * @return the transactionName
	 */
	public String getTransactionName() {
		return transactionName;
	}

	/**
	 * @param transactionName the transactionName to set
	 */
	public void setTransactionName(String transactionName) {
		this.transactionName = transactionName;
	}

	/**
	 * @return the accessedVariable
	 */
	public String getAccessedVariable() {
		return accessedVariable;
	}

	/**
	 * @param accessedVariable the accessedVariable to set
	 */
	public void setAccessedVariable(String accessedVariable) {
		this.accessedVariable = accessedVariable;
	}

	/**
	 * @return the previousOperand
	 */
	public Operand getPreviousOperand() {
		return previousOperand;
	}

	/**
	 * @param previousOperand the previousOperand to set
	 */
	public void setPreviousOperand(Operand previousOperand) {
		this.previousOperand = previousOperand;
	}

	/**
	 * @return the nextOperand
	 */
	public Operand getNextOperand() {
		return nextOperand;
	}

	/**
	 * @param nextOperand the nextOperand to set
	 */
	public void setNextOperand(Operand nextOperand) {
		this.nextOperand = nextOperand;
	}
}
