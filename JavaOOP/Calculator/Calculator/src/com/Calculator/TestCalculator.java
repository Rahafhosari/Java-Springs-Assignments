package com.Calculator;

public class TestCalculator {
    public static void main(String[] args) {
        Calculator sum = new Calculator('+' , 10.0, 10.0);
        Calculator sub = new Calculator('-' , 50, 15);
        Calculator sum1 = new Calculator('+' , sum.getResult(), sub.getResult());

//        sum.setOperation('+');
//        sum.setOperandOne(10.0);
//        sum.setOperandTwo(10.0);
        sum.performOperation();
        sum.getResults();

        sub.performOperation();
        sub.getResults();

        sum1.performOperation();
        sum1.getResults();
    }
}
