package org.khush;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@ToString

public class Address {

    private int streetNo;
    private String street;
    private String city;
    private Province province;
    private String postalCode;

    public enum Province {
        AL, BC, MA, NB, NL, NS, ON, PEI, QC, SK
    }

    public Address(int streetNo, String street, String city, Province province, String postalCode) {
        if (isValidPostalCode(postalCode)) {
            this.streetNo = streetNo;
            this.street = street;
            this.city = city;
            this.province = province;
            this.postalCode = postalCode.toUpperCase();
        }else{
            this.street = null;
            this.city = null;
            this.province = null;
            this.postalCode = null;
        }
    }

    public static boolean isValidPostalCode(String postalCode) {
        if (postalCode == null || postalCode.length() != 6) {
            return false;
        }
        postalCode =postalCode.toUpperCase();

        for (int i = 0; i < postalCode.length(); i += 2) {
            if (!Character.isLetter(postalCode.charAt(i))) {
            return false;

            }
        }

        for (int i = 1; i < postalCode.length(); i += 2) {
            if (!Character.isDigit(postalCode.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    public void setPostalCode(String postalCode) {
        if (isValidPostalCode(postalCode)) {
            this.postalCode = postalCode.toUpperCase();
        }
    }

}
