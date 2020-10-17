package Day4_091220;

public class Split_Message {
    public static void main(String[] args) {

        //declare and define a string variable
        String message= "My name is John";
        //print out only the word John from the string message
        //by using split command
        String[] result= message.split( " ");
        System.out.println("My result is " + result[3]);

    }



}

