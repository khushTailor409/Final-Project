package org.khush;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class Address {

    private int streetNo;
    private String street;
    private String city;
    private Province province;
    private String postalCode; // add the checker and limit to six

    public enum Province {// territory ?
        AL, BC, MA, NB, NL, NS, ON, PEI, QC, SK
        // list = Alberta, British Columbia, Manitoba, New Brunswick, Newfoundland and Labrador, Nova Scotia, Ontario, Prince Edward Island, Quebec, and Saskatchewan

        // helper method
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

    public static boolean isValidPostalCode(String postalCode) { // checks length
        if (postalCode == null || postalCode.length() != 6) {
            return false; // send invalid input instead if you can
        }// make 2 diffrent loops
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

    @Override
    public String toString() {
        return "Address{" +
                "streetNo=" + streetNo +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", province=" + province +
                ", postalCode='" + postalCode + '\'' +
                '}';
    }
}
