package org.khush;

import lombok.*;

@Getter
@ToString
@NoArgsConstructor
@EqualsAndHashCode

public class Department {

    private String departmentId;
    @Setter private String departmentName;
    private static int nextId = 1;

    public Department(String departmentName) {
        if (isDepartmentNameValid(departmentName)) {
            this.departmentName = departmentName;
            this.departmentId = generateDepartmentId();
        } else { this.departmentName = null;
            this.departmentId = null;
        }
    }

    private static String generateDepartmentId() {
        return String.format("D%02d", nextId++);
    }

    public static boolean isDepartmentNameValid(String departmentName) {
        if (departmentName == null || departmentName.isEmpty()) {
            return false;
        }
        for (int i = 0; i < departmentName.length(); i++) { // check if all characters are letters or spaces
            char c = departmentName.charAt(i);
            if (!Character.isLetter(c) && c != ' ') {
                return false;
            }
        }
        return true;
    }
}