package calculate.servlet.dao;

import calculate.servlet.entity.Operation;
import calculate.servlet.entity.User;

import java.util.ArrayList;
import java.util.List;

public class OperationDAO {
    private static List<Operation> operations = new ArrayList<>();

    public void save(Operation operation){
        operations.add(operation);
    }

    public List<Operation> getOperations(){
        return operations;
    }

    public List<Operation> getOperationsByUser(User user){
        List<Operation> newOperations = new ArrayList<>();
        for(Operation op : operations){
            if(op.getUser().equals(user)){
                newOperations.add(op);
            }
        }
        return newOperations;
    }
}
