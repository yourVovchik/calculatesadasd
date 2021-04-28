package calculate.servlet.service;

import calculate.servlet.dao.OperationDAO;
import calculate.servlet.entity.Operation;
import calculate.servlet.entity.User;

import java.util.List;

public class OperationService {
    private final OperationDAO operationDAO = new OperationDAO();

    private void add(Operation operation){
        operationDAO.save(operation);
    }

    public double countUp(String a, String b, String operationMark, User user){
        double doubA = Double.valueOf(a);
        double doubB = Double.valueOf(b);
        add(new Operation(doubA,doubB,CalculateService.calcByMark(operationMark,doubA,doubB),operationMark,user));
        return CalculateService.calcByMark(operationMark,doubA,doubB);
    }

    public boolean checkMark(String mark){
        if(mark.equalsIgnoreCase("SUM") || mark.equalsIgnoreCase("DIF") || mark.equalsIgnoreCase("MUL") ||mark.equalsIgnoreCase("DIV"))
            return true;
        return false;
    }

    public List<Operation> getOperationHistory(){
        return operationDAO.getOperations();
    }

    public List<Operation> getOperationHistoryByUser(User user){
        return operationDAO.getOperationsByUser(user);
    }

    


}
