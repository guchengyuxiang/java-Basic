package io.object;

import java.io.*;

/**
 * @author Cay Horstmann
 * @version 1.10 17 Aug 1998
 */
class ObjectStreamTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Employee harry = new Employee("Harry Hacker", 50000, 1989, 10, 1);

        Manager carl = new Manager("Carl Cracker", 80000, 1987, 12, 15);
        carl.setSecretary(harry);

        Manager tony = new Manager("Tony Tester", 40000, 1990, 3, 15);
        tony.setSecretary(harry);

        Employee[] staff = new Employee[3];

        staff[0] = carl;
        staff[1] = harry;
        staff[2] = tony;

        String fileName = "/Users/hongchaoliang/Documents/git/owner/java-Basic/java-io/src/main/java/io/object/employee.dat";
        // save all employee records to the file employee.dat
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(staff);
        }

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            // retrieve all records into a new array

            Employee[] newStaff = (Employee[]) in.readObject();

            // raise secretary's salary
            newStaff[1].raiseSalary(10);

            // print the newly read employee records
            for (Employee e : newStaff)
                System.out.println(e);
        }
    }
}