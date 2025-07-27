package com.mile1.service;
import com.mile1.bean.Student;

public class StudentService {

    public int findNumberOfNullMarksArray(Student[] s) {
        int count = 0;
        if (s != null) {
            for (Student stu : s) {
                if (stu != null && stu.getMarks() == null) {
                    count++;
                }
            }
        }
        return count;
    }

    public int findNumberOfNullName(Student[] s) {
        int count = 0;
        if (s != null) {
            for (Student stu : s) {
                if (stu != null && stu.getName() == null) {
                    count++;
                }
            }
        }
        return count;
    }

    public int findNumberOfNullObjects(Student[] s) {
        int count = 0;
        if (s != null) {
            for (Student stu : s) {
                if (stu == null) {
                    count++;
                }
            }
        }
        return count;
    }
}
