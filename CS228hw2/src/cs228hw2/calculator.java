package cs228hw2;
/**
 * @Author Haadi Majeed
 */

import java.util.Scanner;

@SuppressWarnings("unchecked")
public class calculator {

    public static void main(String[] args) {
        Deque228<AmusingPreciseNumber> theDeque = new Deque228();
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextLine()) {
            AmusingPreciseNumber firstNumber;
            AmusingPreciseNumber secondNumber;

            String[] input = scan.nextLine().split(" ");
            for (String str : input) {
                switch (str) {
                    case "+":  // if there is + operator
                        System.out.println("adding");

                        firstNumber = theDeque.pop(); // take the top two values (value 1)
                        secondNumber = theDeque.pop(); // take the top two values (value 2)

                        firstNumber.add(secondNumber); // add them together. this can be done using either 1 or 2

                        theDeque.push(firstNumber); // push it back on

                        break;
                    case "-":   // if there is - operator
                        System.out.println("subtracting");

                        firstNumber = theDeque.pop(); // take the top two values (value 1)
                        secondNumber = theDeque.pop(); // take the top two values (value 2)

                        secondNumber.subtract(firstNumber); // subtract them

                        theDeque.push(secondNumber); // push it back on the stack

                        break;
                    case "neg":  // if there is neg operator
                        System.out.println("negating");

                        firstNumber = theDeque.pop(); // take the top number
                        firstNumber.negate(); // negate it

                        theDeque.push(firstNumber); // throw the value back in

                        break;
                    case "abs":  // if there is abs operator
                        System.out.println("abs");

                        firstNumber = theDeque.pop();
                        firstNumber.abs(); // abs value

                        theDeque.push(firstNumber); // throw the value back in

                        break;
                    default:
                        System.out.println("pushing: " + str);
                        try {
                            firstNumber = new AmusingPreciseNumber(str); // create an AmusingPreciseNumber

                            theDeque.push(firstNumber); // add it to the stack
                        } catch (Exception e) {
                            break;
                        }
                        break;
                }

            }
            if (theDeque.size() == 1) { // if we only have one item left which is the desired situation
                break;
            } else {
                System.out.println("Error in input line, please try again"); // We have more than one or no items
                theDeque.clear(); // Retry from a clean deque
            }
        }
        System.out.println(theDeque.pop().toString());
        scan.close();

    }
}
