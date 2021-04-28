package calculate.servlet.entity;

import java.util.Objects;

public class Operation {
    private double a;
    private double b;
    private double answer;
    private String operationMark;
    private User user;

    public Operation(double a, double b, double answer, String operationMark, User user) {
        this.a = a;
        this.b = b;
        this.answer = answer;
        this.operationMark = operationMark;
        this.user = user;
    }

    public Operation() {
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getAnswer() {
        return answer;
    }

    public void setAnswer(double answer) {
        this.answer = answer;
    }

    public String getOperationMark() {
        return operationMark;
    }

    public void setOperationMark(String operationMark) {
        this.operationMark = operationMark;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operation operation = (Operation) o;
        return Double.compare(operation.a, a) == 0 && Double.compare(operation.b, b) == 0 && Double.compare(operation.answer, answer) == 0 && Objects.equals(operationMark, operation.operationMark) && Objects.equals(user, operation.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, answer, operationMark, user);
    }

    @Override
    public String toString() {
        return "|| Operation: "
                + user.getUsername() + " "
                + a + " "
                + b + " "
                + operationMark + " "
                + answer + ".||  \n";
    }
}
