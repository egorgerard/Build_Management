package de.hfu.residents.repository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import de.hfu.residents.domain.Resident;

public class ResidentRepositoryStub implements ResidentRepository {

    List<Resident> r_List = new ArrayList<>();

    // String givenName, String familyName, String street, String city, Date dateOfBirth)

    public ResidentRepositoryStub(){
        r_List.add(new Resident("Stefan", "Bremen", "Hood 25", "Villingen", new Date(2000, 1, 1)));
        r_List.add(new Resident("Dan", "Dreckiger", "Bikini Bottom", "Texas", new Date(2002, 2, 2)));
        r_List.add(new Resident("Larry", "Spitzkopf", "Bikini Toppom", "Nebraska", new Date(2003, 3, 3)));
        r_List.add(new Resident("Garry", "Spitzkopf", "Bikini Toppom", "Nebraska", new Date(2003, 3, 3)));
        r_List.add(new Resident("Sandy", "Cheecks", "Glaßhaus", "Texanisch", new Date(2004, 4, 4)));
        r_List.add(new Resident("Jeff", "Franky", "Hood1", "Bonn", new Date(2020, 10,10)));
        //r_List.add(new Resident("Jeff", "Franky", "Hood1", "Bonn", new Date(2020, 10,10)));
        r_List.add(new Resident("Sandy", "Cheecks", "Glaßhaus", "Texanisch", new Date(2004, 4, 4)));
        
    }
    
    public List<Resident> getResidents() {
        return r_List;
    }    
}
