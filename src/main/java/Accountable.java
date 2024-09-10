package main.java;

/** Interface for Accountables, (e.g., bank accounts). */
public interface Accountable extends Comparable<Accountable> {

  /**
   * Returns the current balance of the account.
   *
   * @return the account balance
   */
  public int getBalance();

  /**
   * Adds to the current account balance, and returns
   * the new account balance.
   *
   * @param amount  the amount to deposit/withdraw
   * @return the new balance of the account
   */
  public int updateBalance(int amount);

  /**
   * Compares this account to the other account to determine
   * if this account is smaller than, equal to, or larger
   * than the other account.
   * <p>
   * Required to implement the {@link Comparable} interface.
   *
   * @param other  the account to compare
   * @return a positive value {@code (> 0)} if this account has a
   * larger balance, {@code 0} if this account has an equivalent balance,
   * or a negative value {@code (< 0)} if this account has a smaller balance.
   */
  public int compareTo(Accountable other);
}
