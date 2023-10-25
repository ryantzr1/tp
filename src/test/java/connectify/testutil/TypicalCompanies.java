package connectify.testutil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import connectify.model.AddressBook;
import connectify.model.company.Company;

/**
 * A utility class to help with building Company objects.
 */
public class TypicalCompanies {
    public static final Company DUMMY_COMPANY = new CompanyBuilder().withName("Unassigned").build();
    public static final Company COMPANY_1 = new CompanyBuilder().withName("Company1").withPhone("64232346")
            .withEmail("company1@gmail.com").withAddress("Blk 456, Ang Mo Kio Ave 10, #-09-123")
            .withIndustry("Customer Service").withLocation("Blk 345, Yio Chu Kang Ave")
            .withNote("A company looking for frontend developers specifically.")
            .withPersonList(new PersonListBuilder().build()).build();
    public static final Company COMPANY_2 = new CompanyBuilder().withName("Banana").withPhone("83464463")
            .withEmail("company2@gmail.com").withAddress("Blk 456, Ang Mo Kio Ave 10, #-09-123")
            .withIndustry("Retail")
            .withNote("A company looking for backend developers specifically.")
            .withLocation("Blk 234, Khatib Drive").build();

    private TypicalCompanies() {} // prevents instantiation

    /**
     * Returns an {@code AddressBook} with all the typical companies
     */
    public static AddressBook getTypicalAddressBook() {
        AddressBook ab = new AddressBook();
        for (Company company : getTypicalCompanies()) {
            ab.addCompany(company);
        }
        return ab;
    }

    public static List<Company> getTypicalCompanies() {
        return new ArrayList<>(Arrays.asList(COMPANY_1, COMPANY_2));
    }
}
