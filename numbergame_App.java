import java.util.Random;
import java.util.Scanner;
class numbergame_results{
    private int digit;
    private int chances;
    private int randomnum;
    private int usernumber;
    private int counter=0;
    public numbergame_results(){
       usernumber=usernumber;
   }
    public void setdigit(int digit){
        this.digit=digit;
    }
    public void setChances(int chances){
        this.chances=chances;
    }
    public int setRandomnumber(){
        Random random = new Random();
        if(digit ==3){
            randomnum = random.nextInt(900)+100;
        } else if (digit==4) {
            randomnum = random.nextInt(9000)+1000;
        } else if (digit==5) {
            randomnum=random.nextInt(90000)+10000;
        }
        return randomnum;
    }
    public void setNumber(int usernumber){
        this.usernumber=usernumber;
    }
    public void decision(){
        for(int i=0;i<chances;i++){
            if(Correct()==0){
                CommonDigits();
                System.out.println("Correct no of digits: "+counter);
                counter=0;
                Positions();
                System.out.println("Correct Positions of digits:  "+(counter));
                counter=0;
                System.out.println("Congratuations, you won");
                break;
            }else if(Correct()==1){
                CommonDigits();
                System.out.println("Correct no of digits: "+counter);
                counter=0;
                Positions();
                System.out.println("Correct Positions of digits: "+counter);
                counter=0;
                break;
            } else if (Correct() ==-1) {
                CommonDigits();
                System.out.println("Correct no of digits: "+counter);
                counter=0;
                Positions();
                System.out.println("Corect Positions of digits: "+counter);
                counter=0;
                break;
            }
        }
    }
    public int Correct(){
        if(usernumber>randomnum){
            return -1;
        }
        else if(usernumber<randomnum){
            return 1;
        }else {
            return 0;
        }
    }
    public int CommonDigits(){
        int temp=randomnum;
        int temp1=usernumber;
        int randomnum[] =new int[10];
        int usernumber[]=new int[10];
        while(temp>0){
            randomnum[temp%10]++;
            temp=temp/10;
        }
        while(temp1>0){
            usernumber[temp1%10]++;
            temp1=temp1/10;
        }
        for(int i=0;i<10;i++){
            if(randomnum[i]>0 && usernumber[i]>0){
                Counter();
            }
        }return 0;
    }
    public void Counter(){
        counter++;
    }
    public void Positions(){
        int num1,num2;
        int temp= randomnum;
        int temp1=usernumber;
        while(temp!=0){
            num1=temp%10;
            temp=temp/10;
            num2=temp1%10;
            temp1=temp1/10;
            if(num1==num2){
                Counter();
            }
        }
    }
}
abstract class numbergame_Questions{
    Scanner in=new Scanner(System.in)
;    public abstract void intro(String intro);
    public abstract void start(String start);
    public void digit(){System.out.println("Please enter which digit number you want to guess (3 or 4 or 5) ");}
    public void three(){System.out.println("Enter a 3 digit number");}
    public void chance(){System.out.println("In how many chances you can guess the number?");}
    public void chances(){System.out.println("Your chances are completed");}
    public void four(){System.out.println("Enter a 4 digit number");}
    public void five(){System.out.println("Enter a 5 digit number");}
    public void three_incorrect(){System.out.println("Invalid input!, Enter a 3 digit number");}
    public void four_incorrect(){System.out.println("Invalid input!,Enter a 4 digit number");}
    public void five_incorrect(){System.out.println("Invalid input! ,Enter a 5 digit number");}
    public void yes_no(){System.out.println("Do you want to play again, Enter yes or no");}
    public void wrongnumber(){System.out.println("Invalid input!, Enter 3 or 4 or 5 digit");}
    public void thank(){System.out.println("Thank You");}
}
class numbergame_decision extends numbergame_Questions{
    public void intro(String intro){
        if(intro.equalsIgnoreCase("yes")){
            System.out.println("Hi\n you must choose which digit number you want to guess? (eg: 3 or 4 or 5)\n Then you have to enter in how many chances you will guess the number. (eg: if you enter '5' then you have to guess the selected digit number in 5 chances)\n EX:3 digit number and 10 chances\n Computer generated random number (which you have to guess) is 523\n You have entered number as 678\n Then the program will give a hint as below\n Correct number of digit: 0\n Correct positions of digits: 0\n another number entered is 521\n Correct number of digits: 2\n Correct positons of digits: 2\n the above steps will be repeated until you guess the correct number or your chances get completed\n if your number is correct you will see a message as 'congratulation you won, do you want to play again(yes or no)'\n if  your chances are completed you will see a message as ' your chances are completed, do you want to play again(yes or no)'" );
        }
    }
    int chances,number;
    public numbergame_decision(){
        this.chances=chances;
        number=number;
    }
    numbergame_results gamestart=new numbergame_results();
    public void start(String start){
        if(start.equalsIgnoreCase("yes")){
            String value;
            do{
                digit();
                int digit=in.nextInt();
                gamestart.setdigit(digit);
                if(digit==3){

                    three_digit();
                }
                else if(digit==4){

                    four_digit();
                }else if(digit==5){
                    five_digit();
                }else{
                    wrongnumber();
                }
                yes_no();
                value=in.next();
            }
            while (value.equalsIgnoreCase("yes"));
            {
                thank();
                in.close();
            }
        }
        else{
            System.out.println("Closed");
        }
    }
    public void three_digit(){
        chance();
        chances=in.nextInt();
        gamestart.setChances(chances);
        int randomnum = gamestart.setRandomnumber();
        for(int i=0;i<chances;i++){
            three();
            number=in.nextInt();
            for (int j=i;j<=i;j++){
                if(number >=100 && number <=999){
                    gamestart.setNumber(number);
                    gamestart.decision();
                }
                else{
                    three_incorrect();
                }
                if(number == randomnum){
                    break;
                }
            }
            if(number == randomnum){
                break;
            }
            if(i == chances-1){
                chances();
                System.out.println("Correct number =" +randomnum);
            }
        }
    }
    public void four_digit(){
        chance();
        chances=in.nextInt();
        gamestart.setChances(chances);
        int randomnum= gamestart.setRandomnumber();
        for(int i=0;i<chances;i++){
            four();
            number=in.nextInt();
            for(int j=i;j<=i;j++){
                if(number > 999 && number <10000){
                    gamestart.setNumber(number);
                    gamestart.decision();
                }
                else{
                    four_incorrect();
                }
                if(number == randomnum){
                    break;
                }
            }
            if(number == randomnum){
                break;
            }
            if(i == chances-1){
                chances();
                System.out.println("Correct number = "+ randomnum);
            }
        }
    }
    public void five_digit(){
        chance();
        chances=in.nextInt();
        gamestart.setChances(chances);
        int randomnum=gamestart.setRandomnumber();
        for(int i=0;i<chances;i++){
            five();
            number=in.nextInt();
            for(int j=i;j<=i;j++){
                if(number >9999 && number <100000){
                    gamestart.setNumber(number);
                    gamestart.decision();
                }
                else{
                    five_incorrect();
                }
                if(number == randomnum){
                    break;
                }
            }
            if(number == randomnum){
                break;
            }
            if( i== chances -1){
                chances();
                System.out.println("Correct number = "+randomnum);            }
        }
    }
}
public class numbergame_App {
    public static void main(String[] args){
        Scanner kin=new Scanner(System.in);
        System.out.println("Do you want to know about the game? (yes or no)");
        numbergame_Questions questions=new numbergame_decision();
        String intro=kin.next();
        questions.intro(intro);
        System.out.println("Let's start the game (yes or no) ");
        String start=kin.next();
        questions.start(start);
    }
}
