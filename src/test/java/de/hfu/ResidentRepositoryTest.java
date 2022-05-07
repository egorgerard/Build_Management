package de.hfu;

import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.easymock.EasyMock.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

import org.junit.Test;

import de.hfu.residents.domain.Resident;
import de.hfu.residents.repository.ResidentRepository;
import de.hfu.residents.repository.ResidentRepositoryStub;
import de.hfu.residents.service.BaseResidentService;
import de.hfu.residents.service.ResidentServiceException;

public class ResidentRepositoryTest {

    private ResidentRepositoryStub stub = new ResidentRepositoryStub();
    private BaseResidentService service = new BaseResidentService();
    private Resident resident = new Resident();

    // *****************************************
    // Tests für getFilteredResidentsList()
    // *****************************************

    // Bei wie vielen Leuten haben den Nachnamen "Dreckiger"
    @Test
    public void getFilteredResidentsListTest() {
        resident.setFamilyName("Dreckiger");
        service.setResidentRepository(stub);
        assertEquals(1, service.getFilteredResidentsList(resident).size());
    }

    // Bei wie vielen Leuten beginnt der Nachname mit "Spitz"
    @Test
    public void getFilteredResidentsList_wW_Test() {
        resident.setFamilyName("Spitz*");
        service.setResidentRepository(stub);
        assertEquals(2, service.getFilteredResidentsList(resident).size());
    }

    // Bei wie vielen Leuten beginnt der Nachname mit "Spitz" und der Vorname mit
    // "ry" endet
    @Test
    public void getFilteredResidentsList_wmW_Test() {
        resident.setFamilyName("Spitz*");
        resident.setGivenName("*ry");
        service.setResidentRepository(stub);
        assertEquals(2, service.getFilteredResidentsList(resident).size());
    }

    // *****************************************
    // Tests für getUniqueResident()
    // *****************************************

    // Ist der Name Unique
    @Test
    public void getUniqueResidentTest() throws ResidentServiceException {
        resident.setFamilyName("Franky");
        Resident r1 = new Resident("Jeff", "Franky", "Hood1", "Bonn", new Date(2020, 10, 10));
        service.setResidentRepository(stub);
        Resident unique_r = service.getUniqueResident(resident);
        assertEquals(r1.getFamilyName(), unique_r.getFamilyName());
    }

    // Zwei mal die selben
    @Test
    public void getUniqueResidentTest2() throws ResidentServiceException {
        resident.setFamilyName("Cheecks");
        service.setResidentRepository(stub);
        try {
            service.getUniqueResident(resident);
            fail();
        } catch (ResidentServiceException e) {

        }
    }

    // Gibt keinen Alonso
    @Test
    public void getUniqueResidentTestNotExistingName() throws ResidentServiceException {
        resident.setFamilyName("Alonso");
        service.setResidentRepository(stub);
        try {
            service.getUniqueResident(resident);
            fail();
        } catch (ResidentServiceException e) {

        }
    }

    //*************************************************
    // MockTest
    //*************************************************

    @Test
    public void getUniqueResidentMockTest(){
        List<Resident> r1 = new ArrayList<>();

        r1.add(new Resident("Stefan", "Bremen", "Hood 25", "Villingen", new Date(2000, 1, 1)));
        r1.add(new Resident("Dan", "Dreckiger", "Bikini Bottom", "Texas", new Date(2002, 2, 2)));
        r1.add(new Resident("Larry", "Spitzkopf", "Bikini Toppom", "Nebraska", new Date(2003, 3, 3)));
        
        ResidentRepository repoMock = createMock(ResidentRepository.class);

        expect(repoMock.getResidents()).andReturn(r1);
        replay(repoMock);
        service.setResidentRepository(repoMock);
        resident.setGivenName("S*");
        assertThat(service.getFilteredResidentsList(resident).size(), equalTo(1));
        verify(repoMock);
    }
     
}
