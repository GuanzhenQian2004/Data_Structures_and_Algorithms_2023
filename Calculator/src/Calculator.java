// Name: Steven Qian
// Computing ID: uen9ke
// Homework: HW2 - Calculator
// Resources: https://www.geeksforgeeks.org/math-pow-method-in-java-with-example/

public class Calculator {



    private int mem1;
    private int mem2;
    private String op;

    public Calculator() {
        mem1 = 0;
        mem2 = 0;
        op = " ";
    }
    public Calculator(int op1, int op2, String newOp) {
        setMem1(op1);
        setMem2(op2);
        setOp(newOp);
    }
    public int getMem1() {
        return mem1;
    }
    public int getMem2() {
        return mem2;
    }
    public String getOp() {
        return op;
    }
    public void setMem1(int op1) {
        mem1 = op1;
    }
    public void setMem2(int op2) {
        mem2 = op2;
    }
    public void setOp(String newOp) {
        if (newOp.equals("+")||newOp.equals("-")||newOp.equals("*")||newOp.equals("/")||newOp.equals("^")) {
            this.op = newOp;}
        else if (this.op == null) {
            this.op = " ";}
    }
    public String toString() {
        return (mem1 + " " + op + " " + mem2);
    }
    public int perform() {
        if (op.equals("+")) {
            mem2 = mem1 + mem2;}
        if (op.equals("-")) {
            mem2 = mem1 - mem2;}
        if (op.equals("*")) {
            mem2 = mem1 * mem2;}
        if (op.equals("/")) {
            if (mem2 == 0) {
                return 0;}
            else {
                mem2 = mem1 / mem2;}}
        if (op.equals("^")) {
            mem2 = (int) Math.pow(mem1, mem2);}
        return mem2;
    }
    public double performDiv() {
        double result = 0.0;
        if (op.equals("/") && mem2 != 0) {
            result = (mem1 * 1.0) / mem2;}
        return result;
    }
    public void swap() {
        int a = mem1;
        int b = mem2;
        mem1 = b;
        mem2 = a;
    }
    public static void main(String[] args){
    }
}