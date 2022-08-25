package org.unibl.etf.tools;

public class UnavailableNameException extends Exception{
    public UnavailableNameException()
    {
        super("The name you entered is not unique!");
    }

}
