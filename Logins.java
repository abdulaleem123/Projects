package com.company;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import static java.nio.file.StandardOpenOption.CREATE;

public  abstract  class Logins {              ////ABSTRACTION 1st class
    public static int noOfUsers=0;
    public int retnoofUsers()
    {
        return noOfUsers;
    }
    File file = new File("password.txt");
    abstract public boolean signup();

    abstract public void Register() throws IOException;
    abstract public void  updateStatus(int checkId) throws IOException;
    abstract public void checkStatus();




}
