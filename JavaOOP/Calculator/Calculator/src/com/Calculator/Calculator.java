package com.Calculator;

public class Calculator {
//Attributes
    private char operation = ' ';
    private double operandOne=0.0;
    private double operandTwo=0.0;
    private double result;

//Constructor
    public Calculator() {}
    public Calculator(char operation, double num1, double num2){
        this.operation = operation;
        this.operandOne = num1;
        this.operandTwo = num2;
    }

//Getters
    public double getResult() {
        return result;
    }

    //Setters
    public void setOperation(char operation) {
        this.operation = operation;
    }

    public void setOperandOne(double operandOne) {
        this.operandOne = operandOne;
    }

    public void setOperandTwo(double operandTwo) {
        this.operandTwo = operandTwo;
    }

    public void setResult(double result) {
        this.result = result;
    }

    //Methods
    public void performOperation(){
        if (this.operation == '+'){
            double result = operandOne + operandTwo;
            setResult(result);
        }
        else if(this.operation == '-'){
            double result = operandOne - operandTwo;
            setResult(result);
        }
    }
//or
//    public void performOperation(char operation,double num1 , double num2){
//        double result = num1 + num2;
//    }

    public void getResults(){
        System.out.println("Result = " + result);
    }

}
