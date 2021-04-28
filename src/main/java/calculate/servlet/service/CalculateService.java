package calculate.servlet.service;

import calculate.servlet.entity.Calculate;

public class CalculateService {
     public static double calcByMark(String mark, double a, double b){
        if(mark.equalsIgnoreCase("SUM")){
            return Calculate.sum(a,b);
        }
        if(mark.equalsIgnoreCase("DIF")){
            return Calculate.difference(a,b);
        }
        if(mark.equalsIgnoreCase("MUL")){
            return Calculate.multiplication(a,b);
        }
        if(mark.equalsIgnoreCase("DIV")){
            return Calculate.division(a,b);
        }
        return 0;
    }


}
