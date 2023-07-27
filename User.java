package com.company;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class User extends Complains {
    Scanner sc = new Scanner(System.in);
    private String email;
    private String password;
    private String name;
    private String age;
    private String nicNo;
    private double income;
    public int checkId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getNicNo() {
        return nicNo;
    }

    public void setNicNo(String nicNo) {
        this.nicNo = nicNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public boolean signup() {
        System.out.println("\t\tLogin");
        System.out.println("\tEmail: ");
        String e = sc.next();
        System.out.println("\tpassword: ");
        String p = sc.next();
        boolean c = false;


        if (e.equals(getEmail()) && p.equals(getPassword())) {
            System.out.println("Login successful");
            c = true;
        } else if (!e.equals(getEmail()) && !p.equals(getPassword())) {
            System.out.println("login failed");
            c = false;
        }
        return c;

    }

    @Override
    public void Register() throws IOException {
        class Registertaion {
            public void register() throws IOException {

                file.createNewFile();
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
                System.out.println("Email: ");
                email = sc.next();
                setEmail(email);


                System.out.println("name: ");
                name = sc.next();
                setName(name);


                System.out.println("age: ");
                age = sc.next();
                setAge(age);

                System.out.println("nic: ");
                nicNo = sc.next();

                setNicNo(nicNo);
                System.out.println("Password: ");
                password = sc.next();

                setPassword(password);
                bufferedWriter.write(getName() + " " + getEmail() + " " + getAge() + " " + getNicNo() + " " + getPassword());
                ++noOfUsers;
                bufferedWriter.close();


            }
        }
        Registertaion r = new Registertaion();
        r.register();

    }

    public  int Number(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
    }

    public  void createRandomDate(int startYear, int endYear) {
        int day = Number(1, 30);
        int month = Number(1, 12);
        int year = Number(startYear, endYear);
        System.out.println("your appointment is scheduled on "+ LocalDate.of(year, month, day));
    }

    public void fileTax() {
        System.out.println("Please enter your income");
        this.income = sc.nextInt();
        if (income < 150000) {
            System.out.println("you are tax free");
        } else {


            double taxRate = 0.2;
            double tax = getIncome() * taxRate;

            System.out.println("your tax is " + tax);
        }

    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    @Override
    public void checkStatus() {
        super.checkStatus();
        System.out.println("enter your complain id to check status");
        checkId=sc.nextInt();
        System.out.println("status is "+getStatus());
    }
}
