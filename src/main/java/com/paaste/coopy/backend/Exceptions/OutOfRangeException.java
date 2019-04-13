package com.paaste.coopy.backend.Exceptions;

public class OutOfRangeException extends Exception
{
    public OutOfRangeException()
    {
        super("Invalid value passed");
    }

    public OutOfRangeException(String message)
    {
        super(message);
    }
}
