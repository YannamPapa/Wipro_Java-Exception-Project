class Employee {
    int empNo;
    String empName;
    String dept;
    char designationCode;
    int basic;
    int hra;
    int it;

    Employee(int empNo, String empName, char designationCode, String dept, int basic, int hra, int it) {
        this.empNo = empNo;
        this.empName = empName;
        this.designationCode = designationCode;
        this.dept = dept;
        this.basic = basic;
        this.hra = hra;
        this.it = it;
    }
}




public class Project1 {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide employee ID.");
            return;
        }

        int empId = Integer.parseInt(args[0]);

        Employee[] employees = {
            new Employee(1001, "Ashish", 'e', "R&D", 20000, 8000, 3000),
            new Employee(1002, "Sushma", 'c', "PM", 30000, 12000, 9000),
            new Employee(1003, "Rahul", 'k', "Acct", 10000, 8000, 1000),
            new Employee(1004, "Chahat", 'r', "Front Desk", 12000, 6000, 2000),
            new Employee(1005, "Ranjan", 'm', "Engg", 50000, 20000, 20000),
            new Employee(1006, "Suman", 'e', "Manufacturing", 23000, 9000, 4400),
            new Employee(1007, "Tanmay", 'c', "PM", 29000, 12000, 10000)
        };

        boolean found = false;

        for (Employee emp : employees) {
            if (emp.empNo == empId) {
                String designation = "";
                int da = 0;

                switch (emp.designationCode) {
                    case 'e':
                        designation = "Engineer";
                        da = 20000;
                        break;
                    case 'c':
                        designation = "Consultant";
                        da = 32000;
                        break;
                    case 'k':
                        designation = "Clerk";
                        da = 12000;
                        break;
                    case 'r':
                        designation = "Receptionist";
                        da = 15000;
                        break;
                    case 'm':
                        designation = "Manager";
                        da = 40000;
                        break;
                }

                int salary = emp.basic + emp.hra + da - emp.it;

                System.out.println("Emp No.\tEmp Name\tDepartment\tDesignation\tSalary");
                System.out.println(emp.empNo + "\t" + emp.empName + "\t\t" + emp.dept + "\t\t" + designation + "\t" + salary);

                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("There is no employee with empid : " + empId);
        }
    }
}
