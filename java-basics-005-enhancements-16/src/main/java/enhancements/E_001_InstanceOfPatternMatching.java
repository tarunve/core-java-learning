package enhancements;

import lombok.Getter;

/**
 *  -   Generally, pattern matching is referred to as testing some data to see if it has a
 *      particular structure and verifying it is a match or not, as we do in regular expressions.
 *  -
 */
public class E_001_InstanceOfPatternMatching {

    @Getter
    static class Customer {
        private String firstName, middleName, lastName;
    }

    @Getter
    static class PersonalCustomer extends Customer { }

    @Getter
    static class BusinessCustomer extends Customer {
        private String legalName;
    }

    // traditional - check if an object is of type A or B because how we handle each type is different.
    public void traditional() {
        Customer customer = new Customer();
        String customerName;

        if(customer instanceof PersonalCustomer)
        {
            PersonalCustomer pc = (PersonalCustomer) customer; //Redundant casting
            customerName = String.join(" ", pc.getFirstName(), pc.getMiddleName(), pc.getLastName());
        }
        else if(customer instanceof BusinessCustomer)
        {
            BusinessCustomer bc = (BusinessCustomer) customer; //Redundant casting
            customerName = bc.getLegalName();
        }
    }

    /**
     *  So essentially, a type test pattern (used in instanceof) consists of a predicate specifying
     *  a type and a single binding variable. we can deduce from the above definition that a pattern
     *  is a combination of :
     *  -   a predicate that can be applied to a target, and
     *  -   a set of binding variables that are extracted from the target only if the predicate
     *      successfully applies
     */
    public void patternMatching() {
        Customer customer = new Customer();
        String customerName;

        if(customer instanceof PersonalCustomer pc)
        {
            //Redundant casting
            customerName = String.join(" ", pc.getFirstName(), pc.getMiddleName(), pc.getLastName());
        }
        else if(customer instanceof BusinessCustomer bc)
        {
            //Redundant casting
            customerName = bc.getLegalName();
        }
    }
}
