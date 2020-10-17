package Action_item;

public class action_item1 {
    public static void main(String[] args) {
        int grade = 65; //user inputs grade here

        if (grade >=90 && grade<=100) {
            System.out.println("The grade is A");
        } else if (grade >=80 && grade<=90) {
            System.out.println("The grade is B");
        } else if (grade >=70 && grade<=80) {
            System.out.println("The grade is C");
        } else if (grade >=60 && grade<=70) {
            System.out.println("The grade is D");
        } else { //any grade below 60
            System.out.println("The grade is F");
        }
    }



}


