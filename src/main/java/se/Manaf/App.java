package se.Manaf;


import java.util.*;

/**
 * Hello world!
 *
 */
public class App 
{
    static List<Double> numbers = new ArrayList<>() ;
    static List<Character> orderedOperator = new ArrayList<>() ;


    static Character [] NUMBERS =  {'0','1','2','3','4','5','6','7','8','9','.'};
    static Collection<Character> numberList= Arrays.asList(NUMBERS);
    static final Character  [] OPERATOR = {'+','-','*','/'};
    static Collection<Character> operatorList= Arrays.asList(OPERATOR);
    static final Character [] parenthesis ={'(',')'};

    public static void main( String[] args ){


        System.out.println("Please, Enter your calculation as formula. \nFor Example: 27.5-3+4-20.1\n");
        Scanner scanner=new Scanner(System.in);

        String input=scanner.next();
        separateContent(input);

        System.out.println("the result: " + input +" = "+result());



    }

    static double result(){
        boolean first=true;
        double result= 0;
        for (int i=0; i<numbers.size()-1;i++) {
            switch (orderedOperator.get(i)) {
                case '+':
                    if (first) {
                        result = addition(numbers.get(i), numbers.get(i + 1));
                        first = false;
                    } else result = addition(result, numbers.get(i + 1));
                    break;
                case '-':
                    if (first) {
                        result = subtraction(numbers.get(i), numbers.get(i + 1));
                        first = false;
                    } else result = subtraction(result, numbers.get(i + 1));
                    break;
            }
        }
        return result;
    }

    static void separateContent(String input){
        char [] characters = input.toCharArray();
        String combiningNumber = "";
        //boolean isPreviousIsNumber=false;
        for (char ch: characters){
            if (numberList.contains(ch)){
                combiningNumber = combiningNumber.concat(Character.toString(ch));
                //isPreviousIsNumber =true;
            }
            else {
                if (combiningNumber!="") {
                    numbers.add(Double.parseDouble(combiningNumber));
                combiningNumber = "";
                }
                if (operatorList.contains(ch)) orderedOperator.add(ch);
                //isPreviousIsNumber=false;
            }

        }
        numbers.add(Double.parseDouble(combiningNumber));
    }


    static double addition(double number1, double number2){
        return  number1+number2;
    }
    static double subtraction(double number1, double number2){
        return  number1-number2;
    }
    static double multiplication(double number1, double number2){
        return  number1*number2;
    }
    static double division(double number1, double number2){
        return  number1/number2;
    }
}
