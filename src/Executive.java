//Executive.java
//Author: Shimer, Jacob D.
//This is the executive class.  It inherits and extends the employee

class Executive extends Employee {
    private float stockPrice;

    public Executive(String empName, float monSalary, float stockPrice){
        super(empName, monSalary);
        this.stockPrice = stockPrice;
    }

    // This is to calculate the annual salary of executives.  If its less then 50
    // it calculates a basic salary, else it'll add $30000 to the executive salary
    public float annualSalary() {
        if (stockPrice < 50) {
            return (getMonSalary() * 12);
        } else {
            return ((getMonSalary() * 12) + 30000);
        }
    }

    public String toString() {
        return super.toString() + "\n\tCompany Stock Price:" + stockPrice;
    }

    // This is purely to make displaying the program in a nicer manner
    public void display(){
        System.out.println("<<Executive>>" + this);
    }
}
