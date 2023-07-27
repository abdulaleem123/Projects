package com.company;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
///2ND CLASS

public class Complains extends Logins{

    @Override
    public void updateStatus(int checkId) throws IOException {

    }

    @Override
    public void checkStatus() {

    }

    @Override
    public void Register() throws IOException {

    }

    @Override
    public boolean signup() {
        return false;
    }

    Scanner sc = new Scanner(System.in);
    private String complain;

    public String getComplain() {
        return complain;
    }

    public void setComplain(String complain) {
        this.complain = complain;
    }

    private int complainId;

    public int getComplainId() {
        return complainId;
    }

    public void setComplainId(int complainId) {
        this.complainId = complainId;
    }
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    ArrayList<Integer> uniqueId=new ArrayList<>();
    static int counter =0;
    public void addComplain() throws IOException {
        file.createNewFile();
        char ch=0;
        while (ch!='n') {
            System.out.println("please choose field");
            System.out.println("\t1.Water");
            System.out.println("\t2.Electricity");
            System.out.println("\t3.Gas");
            System.out.println("\t4.Sewerage");
            System.out.println("\t5.General Complaint");
            int choice = sc.nextInt();
            System.out.println("please write down your complain below and mention all the details");
            complain=sc.next();
            setComplain(complain);
            System.out.println("complain registered successfully");

            //int complainId = ThreadLocalRandom.current().nextInt(999);
            int id = getRandomNumberUsingNextInt(5,999);
            for (int i = 0; i < counter; i++) {

                setComplainId(id);
                uniqueId.add(complainId);
                if (uniqueId.get(i) == complainId) {
                    id = getRandomNumberUsingNextInt(5,999);
                    setComplainId(id);
                    uniqueId.add(complainId);

                }
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            bufferedWriter.write(getComplainId()+" "+getComplain()+" "+getStatus()+" ");
            bufferedWriter.close();


            System.out.println("your complain id is " +getComplainId() );
            System.out.println("do you want to add any other complain (y/n)");
            ch = sc.next().charAt(0);
            ++counter;
        }
    }

    public int getRandomNumberUsingNextInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;      // RANDOM NUMBER GENERATOR
    }

}
