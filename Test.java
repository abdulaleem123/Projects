package com.company;

import java.io.IOException;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Admin admin = new Admin();
        char c = 0;
        while (c!='n') {

            System.out.println("\t\t *****************");
            System.out.println("\t\t    Welcome! ");
            System.out.println("\t\t *****************");

            System.out.println("\n\t Menu ");
            System.out.println("\t1.Register\n\t2.Login\n\t3.Admin");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    admin.Register();
                case 2:
                    boolean r = admin.signup();
                    if (r) {
                        System.out.println("choose any option\n1.add complain\n2.File tax\n3.pre appointment\n4.Complain status");
                        int o = sc.nextInt();
                        switch (o)
                        {
                            case 1:
                                admin.addComplain();

                            case 2:
                                admin.fileTax();

                            case 3:
                                System.out.println("1.get nic token\n2.get license token\n3.get passport token");
                                int opt = sc.nextInt();
                                admin.createRandomDate(2022,2022);

                            case 4:
                                admin.checkStatus();
                        }


                    } else System.out.println("wrong password");
                case 3:
                    admin.adminFunctions();
            }
            System.out.println("do you want to continue");
            c=sc.next().charAt(0);
        }
    }
}
