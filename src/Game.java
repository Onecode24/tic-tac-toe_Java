import java.util.Scanner;

public class Game {
    public static char[] array=new char[]{' ',' ',' ',' ',' ',' ',' ',' ',' '};

    public static void main(String[] args) {
        Scanner read=new Scanner(System.in);
        String pl1,pl2;
        System.out.print("Enter player X name:");
        pl1=read.nextLine();
        System.out.print("Enter player O name:");
        pl2=read.nextLine();
        display(array);
        int k=0,l=0;
        while(l<9 && !check(array)){
            Scanner readPlace=new Scanner(System.in);
            if(k%2==0){
                System.out.print(pl1+" turn : ");
            }else if(k%2==1){
                System.out.print(pl2+" turn : ");
            }
            int it=readPlace.nextInt();
            while(array[it]!=' '){

                if(k%2==0){
                    System.out.print(pl1+" This position is not possible enter another position : ");
                }else if(k%2==1){
                    System.out.print(pl2+" This position is not possible enter another position : ");
                }
                it=readPlace.nextInt();
            }
            placeIt(it,(k%2+1));
            display(array);
            if(check(array) && (k%2+1)==1){
                System.out.println(pl1 +" Win this game");
                return;
            }else  if(check(array) && (k%2+1)==2){
                System.out.println(pl2 +" Win this game");
                return;
            }
            k++;l++;
        }

    }

    //function to display the game
    public static void display(char[] array){
        int nbr=0;
        for(int i=0;i<3; i++ ){
            System.out.print("|");
            for (int j=0; j<3; j++){
                System.out.print(array[nbr]+"|");
                nbr++;
            }
            System.out.println();
           /* for (int j=0; j<3; j++){
                System.out.print(" _");
            }
            System.out.println();*/
        }
    }

    //Check if someone wins the game
    static boolean check(char[] args) {
        char[] bool=new char[]{'X','O'};
        for (char i : bool) {
            if (args[0] == i && args[1]==i && args[2]==i && i!=' ') return true;
            else if(args[3] == i && args[4]==i && args[5]==i && i!=' ') return true;
            else if (args[6] == i && args[7]==i && args[8]==i && i!=' ') return true;
            else if (args[0] == i && args[4]==i && args[8]==i && i!=' ') return true;
            else if (args[2] == i && args[4]==i && args[6]==i && i!=' ') return true;
            else if (args[0] == i && args[3]==i && args[6]==i && i!=' ') return true;
            else if (args[1] == i && args[4]==i && args[7]==i && i!=' ') return true;
            else if (args[2] == i && args[5]==i && args[8]==i && i!=' ') return true;

        }
        return false;
    }

    static void placeIt(int n,int x){
        for (int i = 0; i < array.length; i++) {
            if(i==n && x==1){
                array[i]='X';
            }else if(i==n && x==2){
                array[i]='O';
            }
        }
    }

}
