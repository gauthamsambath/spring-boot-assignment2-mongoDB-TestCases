package com.stackroute.MuzixApplication.CustomEcxeptions;

public class EmpyFieldExeption extends Exception
    {
        String message;

        public EmpyFieldExeption() {
        }

        public EmpyFieldExeption(String message) {
            super(message);
            this.message = message;
        }
    }
