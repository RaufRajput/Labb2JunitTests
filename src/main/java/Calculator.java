import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Calculator {

        private int number;

    public Calculator() {
        }

    public Calculator( int number){
            this.number = number;
        }


        public int getNumber () {
            return number;
        }

        public int subtraction ( int i, int i1){
            return i - i1;
        }

        public int addition ( int i, int i1){
            return i + i1;

        }

        public int multiplication ( int i, int i1){
            return i * i1;

        }

        public int division ( int i, int i1){
            if (i1 == 0) {
                errorDivideByZero();
            }
            return i / i1;

        }
        private int divisionPrivate ( int a, int b){
            if (a == 0) {
                throw new IllegalArgumentException("Dividing by zero is not possible, try again");
            }
            return a / b;

        }

        private void errorDivideByZero () {
            System.out.println("Dividing by zero is not possible, try again");
            throw new ArithmeticException();
        }

        public List<String> calculatorMenu () {
            List<String> menuList = new ArrayList<>();
            menuList.add("Please choose an option for your calculator");
            menuList.add("Pick 1 for addition");
            menuList.add("Pick 2 for subtraction");
            menuList.add("Pick 3 for multiplication");
            menuList.add("Pick 4 for division");
            menuList.add("For exit press e");

            return menuList;

        }


    }

