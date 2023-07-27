package com.company;

import java.io.IOException;

public class Admin extends User{
    @Override
    public void updateStatus(int checkId) throws IOException {
        super.updateStatus(checkId);
        System.out.println("enter status ");
        String s = sc.next();
        setStatus(s);

        System.out.println(getStatus());
    }

    private String adminEmail;
    private String adminPassword;

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }
    public void adminFunctions() throws IOException {
        System.out.println("enter user name");
        adminEmail= sc.next();;
        System.out.println("enter password");
        adminPassword=sc.next();
        if (adminEmail.equals("user")&& adminPassword.equals("user"))
        {
            System.out.println("verified");
            System.out.println("\n1.Update status\n2.check total no. of users");
            int c = sc.nextInt();
            if (c==1)
            {
                System.out.println("enter complain id to update ");
                int id =sc.nextInt();
                updateStatus(id);
            }
            if (c==2)
            {
                retnoofUsers();
            }
        }
        else
            System.out.println("access denied");
    }

}
