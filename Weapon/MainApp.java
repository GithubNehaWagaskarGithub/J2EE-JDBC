package Weapon;

import java.util.Scanner;

public class MainApp
{
    private static Scanner sc=new Scanner(System.in);
    private static WeaponOperation wo=new WeaponOperation();

    public static void operation()
    {
        boolean status=true;
        while(status)
        {
            System.out.println("1. Display Weapon names whose damage is worst :");
            System.out.println("2. Display Weapon details whose range is between 400-600 :");
            System.out.println("3. Display Weapon Types & there count present inside in table :");
            System.out.println("4. Display Total Damage done by Assault Riffle :");
            System.out.println("5. Display Weapon names which does not contain 'C' Character :");
            System.out.println("6. Display All the Weapon Names & Weapon Type after remaining 'ff' from their name :");
            System.out.println("7. Exit");
            System.out.println();
            System.out.println("Enter your Choice :");
            int ch=sc.nextInt();

            switch (ch)
            {
                case 1:
                    damageIsWorst();
                    break;
                case 2:
                    weaponRangeBetween400And600();
                    break;
                case 3:
                    WeaponTypesAndThereCount();
                    break;
                case 4:
                    TotalDamageDoneByAssaultRiffle();
                    break;
                case 5:
                    WeaponNamesWhichDoesNotContainCCharacter();
                    break;
                case 6:
                    WeaponNamesAndWeaponTypeAfterRemovingFFFromTheirName();
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Choice :");
                    break;
            }
        }
    }
    //-----------------------------------------------------------------------------------------------------------------------
    private static void damageIsWorst()
    {
        wo.damageIsWorst();
    }
    //------------------------------------------------------------------------------------------------------------------------
    private static void weaponRangeBetween400And600()
    {
        wo.weaponRangeBetween400And600();
    }
    //-----------------------------------------------------------------------------------------------------------------------
    private static void WeaponTypesAndThereCount()
    {
        wo.WeaponTypesAndThereCount();
    }
    //-----------------------------------------------------------------------------------------------------------------------
    private static void TotalDamageDoneByAssaultRiffle()
    {
        wo.TotalDamageDoneByAssaultRiffle();
    }
    //------------------------------------------------------------------------------------------------------------------------
    private static void WeaponNamesWhichDoesNotContainCCharacter()
    {
        wo.WeaponNamesWhichDoesNotContainCCharacter();
    }
    //-------------------------------------------------------------------------------------------------------------------------
    private static void WeaponNamesAndWeaponTypeAfterRemovingFFFromTheirName()
    {
        wo.WeaponNamesAndWeaponTypeAfterRemovingFFFromTheirName();
    }
    public static void main(String[] args) {
        operation();
    }
}
