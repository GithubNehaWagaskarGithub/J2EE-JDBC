package IPL;

import java.util.Scanner;
public class MainApp {
    private static Scanner sc=new Scanner(System.in);
    private static IPLOperation io=new IPLOperation();
        private static void operation()
        {
            boolean status=true;
            while(status)
            {
                System.out.println("1. Qualified Teams");
                System.out.println("2. Performance");
                System.out.println("3. Win-Loss 50-50");
                System.out.println("4. Tied");
                System.out.println("5. Wining matches are > losing matches");
                System.out.println("6. Teams according to Points");
                System.out.println("7. Exit");
                System.out.println();
                System.out.println("Enter your Choice :");
                int ch=sc.nextInt();
                switch (ch)
                {
                    case 1:
                        qualifiedTeams();
                        break;
                    case 2:
                        System.out.println("1. Best");
                        System.out.println("2. Worst");
                        System.out.println("3. Avg");
                        int ch1=sc.nextInt();
                        switch(ch1)
                        {
                            case 1:
                                best();
                                break;
                            case 2:
                                worst();
                                break;
                            case 3:
                                avg();
                                break;
                            case 4:
                                System.exit(0);
                                break;
                            default:
                                System.out.println("Invalid Choice");
                                break;
                        }
                        break;
                    case 3:
                        win_Loss();
                        break;
                    case 4:
                        tied();
                        break;
                    case 5:
                        winGreaterThanLoss();
                        break;
                    case 6:
                        teamAccordingPoints();
                        break;
                    case 7:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid Choice");
                        break;
                }
            }
        }

    //------------------------------------------------------------------------------------------------------------------------
    private static void qualifiedTeams()
    {
        io.qualifiedTeams();
    }
    //----------------------------------------------------------------------------------------------------------------------
    private static void best()
    {
        io.best();
    }
    private static void worst()
    {
        io.worst();
    }
    private static void avg()
    {
        io.avg();
    }

    //---------------------------------------------------------------------------------------------------------------------
    private static void win_Loss()
    {
        io.win_Loss();
    }

    //-------------------------------------------------------------------------------------------------------------------------
    private static void tied()
    {
        io.tied();
    }
    //---------------------------------------------------------------------------------------------------------------------------
    private static void winGreaterThanLoss()
    {
        io.winGreaterThanLoss();
    }
    //----------------------------------------------------------------------------------------------------------------------
    private static void teamAccordingPoints()
    {
        io.teamAccordingPoints();
    }
    //-------------------------------------------------------------------------------------------------------------------------
    public static void main(String[] args)
    {
        operation();
    }
}
