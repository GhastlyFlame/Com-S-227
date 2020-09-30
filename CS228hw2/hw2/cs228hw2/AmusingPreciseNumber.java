package cs228hw2;
/**
 * @Author Haadi Majeed
 */

import java.io.Reader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class AmusingPreciseNumber {
    private List<BigDecimal> number = new ArrayList<BigDecimal>() {
        {
            add(new BigDecimal("0"));
        }
    };

    /**
     * Create an AmusingPreciseNumber from an int type.
     *
     * @param numb to create from
     */
    public AmusingPreciseNumber(int numb) {
        this(String.valueOf(numb));
    }

    /**
     * Create an AmusingPreciseNumber from a String. The formatting of the string is some number of digits
     * with an optional decimal point. Your constructor is required to throw a runtime exception if the string
     * does not have a valid syntax. Valid strings do include 0, 0.0, 0000, 00000123, 00000123.000001000, -
     * 23432, +1234., and +1234555. That is, leading or trailing zeros, a single leading plus or minus sign,
     * and no plus or minus sign are all valid numbers. In effect, any reasonable string of digits (no matter
     * how long) that can be interpreted as a number is valid.
     *
     * @param numb string to create from
     */
    public AmusingPreciseNumber(String numb) {
        number.set(0, new BigDecimal(numb));
    }

    /**
     * Instantiates a new Amusing precise number.
     *
     * @param r the r
     */
    public AmusingPreciseNumber(Reader r) {
        try {
            if (r != null) {
                int k;
                StringBuilder s = new StringBuilder();
                while ((k = r.read()) != -1) {
                    if (Character.isWhitespace(k)) {
                        break;
                    }
                    s.append((char) k);
                }

                r.close();

                number.set(0, new BigDecimal(s.toString()));
            }
        } catch (Exception ignored) {
        }
    }

    /**
     * Instantiates a new Amusing precise number.
     *
     * @param numb the numb
     */
    public AmusingPreciseNumber(AmusingPreciseNumber numb) {
        number = new ArrayList<>(numb.getList());
    }

    /**
     * Add amusing precise number.
     *
     * @param numb1 the numb 1
     * @param numb2 the numb 2
     * @return the amusing precise number
     */
    public static AmusingPreciseNumber add(AmusingPreciseNumber numb1, AmusingPreciseNumber numb2) {
        AmusingPreciseNumber out = new AmusingPreciseNumber(numb1);
        out.add(numb2);

        return out;
    }

    /**
     * Subtract amusing precise number.
     *
     * @param numb1 the numb 1
     * @param numb2 the numb 2
     * @return the amusing precise number
     */
    public static AmusingPreciseNumber subtract(AmusingPreciseNumber numb1, AmusingPreciseNumber numb2) {
        AmusingPreciseNumber c = new AmusingPreciseNumber(numb1);
        c.subtract(numb2);

        return c;
    }

    /**
     * Negate amusing precise number.
     *
     * @param numb1 the numb
     * @return the amusing precise number
     */
    public static AmusingPreciseNumber negate(AmusingPreciseNumber numb1) {
        AmusingPreciseNumber out = new AmusingPreciseNumber(numb1);
        out.negate();

        return out;
    }

    /**
     * Absolute value of the input amusing precise number.
     *
     * @param numb1 the number to be absolute-d
     * @return the amusing precise number
     */
    public static AmusingPreciseNumber abs(AmusingPreciseNumber numb1) {
        AmusingPreciseNumber out = new AmusingPreciseNumber(numb1);
        out.abs();

        return out;
    }

    /**
     * Number to add to the current value
     *
     * @param numb to add to the current one
     */
    public void add(AmusingPreciseNumber numb) {
        number.set(0, number.get(0).add(numb.getList().get(0)));
    }

    /**
     * Subtract the input from the current number
     *
     * @param numb to be removed from the current
     */
    public void subtract(AmusingPreciseNumber numb) {
        number.set(0, number.get(0).subtract(numb.getList().get(0)));
    }

    /**
     * Flips the sign from its current one
     */
    public void negate() {
        number.set(0, number.get(0).negate());
    }

    /**
     * Sets the sign to be positive
     */
    public void abs() {
        number.set(0, number.get(0).abs());
    }

    private List<BigDecimal> getList() {
        return number;
    }

    /**
     * Sends the value into a string
     *
     * @returns the string to the asker
     */
    @Override
    public String toString() {
        return number.get(0).toString();
    }
}