package Problem1;

/*
Abdul Arif
ID: 105075345
Assignment 3
 */
import java.lang.*; //Imports needed libraries

/**
 * This is an interface to format an input number into a string
 */
public interface NumberFormatter{
  String format(int n);
}

/**
 * This is a class to format a number in the default given value, implements NumberFormatter
 */
class DefaultFormatter implements NumberFormatter{
  /**
   * Formats and returns string of numbers in default form
   * @param n int number to format
   * @return String number of new format
   */
  public String format(int n){ // formatting integer
    return String.valueOf(n); // returns the value of the string
  }
}

/**
 * This is a class to format a number in comma-decimal notation, implements NumberFormatter
 */
class DecimalFormatter implements NumberFormatter{
  /**
   * Formats and returns string of numbers to have a comma every 3 digits
   * @param n int number to format
   * @return String number of new format
   */
  public String format(int n){ 
    return String.format("%,d", n); 
  }

}

/**
 * This is a class to format a number where negatives are in brackets, implements NumberFormatter
 */
class AccountingFormatter implements NumberFormatter{
  /**
   * Formats and returns string of number to have negatives in brackets, otherwise default
   * @param n int number to format
   * @return String number of new format
   */
  public String format(int n){
    return n < 0 ? String.format("(%d)", Math.abs(n)) : String.valueOf(n); //Fancy schmancy if/else statements to simplify return conditions
  }
}

/**
 * This is a class to format a number in a given "base" format, implements NumberFormatter
 */
class BaseFormatter implements NumberFormatter{

  private int base; //int base system

  /**
   * Creates Baseformatter object with input base within range otherwise defaults to 2
   * @param inpBase int base system to use
   */
  public BaseFormatter(int inpBase){
    this.base = inpBase;
    if(base < 2 || base > 16){
      base = 2; //  base case if out of range
    }
  }

  /**
   * Formats and returns string of number to follow input base format
   * @param n int number to format
   * @return String number of new format
   */
  public String format(int n){
    return Integer.toString(n, base);
  }

  /**
   * Gets and returns base value of system
   * @return int value of base system
   */
  public int getBase(){
    return base; 
  }

}
