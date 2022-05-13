import dbapp.Dbapp;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DbappTest {

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";

    private static final String START_TESTS_IDENTIFIER = "\n###_AUTOGRADING_TESTS_START_###\n";
    private static final String END_TESTS_IDENTIFIER = "\n###_AUTOGRADING_TESTS_END_###\n";

    @BeforeAll
    static void beforeAll() {
//        try {
//            prepareTables();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
        System.out.print(START_TESTS_IDENTIFIER);
    }

    @AfterAll
    static void afterAll() {
        System.out.print(END_TESTS_IDENTIFIER);
    }
    
    private static ResultSet rs = null;


    // POCET
    @Test
    public void UT01pocet_3b() {
        TestResult tr = new TestResult();
        tr.setStudentIdentifier("74144");
        tr.setTestIdentifier("UT01pocet_3b");
        tr.setNumberOfPoints(3);

        tr.setExpectedValue("1, 2");

        int r1 = -1;
        int r2 = -1;

        try {
            r1= Dbapp.pocetFaktur("Z1");
            r2= Dbapp.pocetFaktur("Z2");

            tr.setActualValue(r1 + ", " + r2);

            tr.setTestResult((r1 == 1 && r2 == 2) ? TestResultTypeEnu.CORRECT : TestResultTypeEnu.FAIL);

        } catch (Exception e) {
            tr.setTestResult(TestResultTypeEnu.FAIL);
            tr.setDetails(e.getMessage());
        }

        System.out.println(tr);
    }
    
//    @Test
//    public void UT02pocet_2b() {
//        int r3= -1;
//        try {
//                r3= Dbapp.pocetFaktur("Z3");
//        } catch (Exception e) {
//            tr.setTestResult(TestResultTypeEnu.FAIL);
//            tr.setDetails(e.getMessage());
//        }
//        assertEquals(0,r3);
//    }
//
//    // PRIDAJ
//    // do 1 (mala 2)
//    // do 3 (mala 0)
//    // do 4 (neexistuje)
//    @Test
//    public void UT03pridaj_2b() {
//        int r= -1;
//        try {
//                Dbapp.pridajPolozku(1, "pivo", 2.0);
//                Dbapp.pridajPolozku(3, "pivo", 1.5);
//        } catch (Exception e) {
//            tr.setTestResult(TestResultTypeEnu.FAIL);
//            tr.setDetails(e.getMessage());
//        }
//    }
//
//    @Test
//    public void UT04pridaj4_2n() {
//        int r= -1;
//        try {
//                Dbapp.pridajPolozku(4, "pivo", 2.0);
//        } catch (Exception e) {
//            tr.setTestResult(TestResultTypeEnu.FAIL);
//            tr.setDetails(e.getMessage());
//        }
//    }
//
//    // kontrola aktualizacie
//    @Test
//    public void UT05date_1b() {
//        String d1 = null;
//        String d2 = null;
//        try (Connection con = DriverManager.getConnection(DB_URL, "postgres", "postgres")) {
//            Statement st = con.createStatement();
//            rs = st.executeQuery("SELECT aktualizacia FROM FAKTURA WHERE id=1");
//            rs.next();
//            d1 = rs.getString("AKTUALIZACIA");
//
//            rs = st.executeQuery("SELECT aktualizacia FROM FAKTURA WHERE id=2");
//            rs.next();
//            d2 = rs.getString("AKTUALIZACIA");
//        } catch (SQLException ex) {
//            fail("CHYBA SQL: " + ex.getMessage());
//        }
//        assertNotNull("aktualizacia mala byt zmenena",d1);
//        assertNull("aktualizacia nemala byt zmenena",d2);
//    }
//
//
//    // kontroly
//    // 1 pocet poloziek = 3
//    // 3 pocet poloziek = 1
//    // 3 cena 1. polozky = 1.5
//    @Test
//    public void UT06pocetpol_1b() {
//        int n = 0;
//        try (Connection con = DriverManager.getConnection(DB_URL, "postgres", "postgres")) {
//            Statement st = con.createStatement();
//            rs = st.executeQuery("SELECT count(*) FROM POLOZKA WHERE FAKTURA_ID=1");
//            rs.next();
//            n = rs.getInt(1);
//        } catch (SQLException ex) {
//            fail("CHYBA SQL: " + ex.getMessage());
//        }
//        assertEquals(3, n);
//    }
//
//    @Test
//    public void UT07pocetpol_1b() {
//        int n = 0;
//        try (Connection con = DriverManager.getConnection(DB_URL, "postgres", "postgres")) {
//            Statement st = con.createStatement();
//            rs = st.executeQuery("SELECT count(*) FROM POLOZKA WHERE FAKTURA_ID=3");
//            rs.next();
//            n = rs.getInt(1);
//        } catch (SQLException ex) {
//            fail("CHYBA SQL: " + ex.getMessage());
//        }
//        assertEquals(1, n);
//    }
//
//    @Test
//    public void UT08cena_1b() {
//        double d = 0;
//        try (Connection con = DriverManager.getConnection(DB_URL, "postgres", "postgres")) {
//            Statement st = con.createStatement();
//            rs = st.executeQuery("SELECT cena FROM POLOZKA WHERE FAKTURA_ID=3");
//            rs.next();
//            d = rs.getDouble("CENA");
//        } catch (SQLException ex) {
//            fail("CHYBA SQL: " + ex.getMessage());
//        }
//        assertEquals(1.5, d, 0.001);
//    }
//
//    // kontroly
//    // pocet piv spolu = 2
//    // pocet poloziek spolu
//    // pocet zmluv spolu
//    @Test
//    public void UT09chekpolozky_1b() {
//        int n1 = 0;
//        int n2 = 0;
//        try (Connection con = DriverManager.getConnection(DB_URL, "postgres", "postgres")) {
//            Statement st1 = con.createStatement();
//            rs = st1.executeQuery("SELECT count(*) FROM POLOZKA WHERE PRODUKT='pivo'");
//            rs.next();
//            n1 = rs.getInt(1);
//            Statement st2 = con.createStatement();
//            rs = st1.executeQuery("SELECT count(*) FROM POLOZKA");
//            rs.next();
//            n2 = rs.getInt(1);
//
//        } catch (SQLException ex) {
//            fail("CHYBA SQL: " + ex.getMessage());
//        }
//        assertEquals(2, n1);
//        assertEquals(5, n2);
//    }
//
//    @Test
//    public void UT99check_2n() {
//        int d = -1;
//        try (Connection con = DriverManager.getConnection(DB_URL, "postgres", "postgres")) {
//            Statement st = con.createStatement();
//            rs = st.executeQuery("SELECT count(*) FROM FAKTURA");
//            rs.next();
//            d = rs.getInt(1);
//        } catch (SQLException ex) {
//            fail("CHYBA SQL: " + ex.getMessage());
//        }
//        assertEquals(3,d);
//    }


    static private void prepareTables() throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");

        try (Connection con = DriverManager.getConnection(DB_URL, "postgres", "postgres")) {
            Statement st = con.createStatement();
            st.executeUpdate("DELETE FROM POLOZKA");
            st.executeUpdate("DELETE FROM FAKTURA");
            st.executeUpdate("INSERT INTO FAKTURA VALUES (1, NULL, 'Z1')");
            st.executeUpdate("INSERT INTO FAKTURA VALUES (2, NULL, 'Z2')");
            st.executeUpdate("INSERT INTO FAKTURA VALUES (3, NULL, 'Z2')");
            st.executeUpdate("INSERT INTO POLOZKA VALUES (11, 11.90 , 'P11', 1)");
            st.executeUpdate("INSERT INTO POLOZKA VALUES (12, 21.90 , 'P12', 1)");
            st.executeUpdate("INSERT INTO POLOZKA VALUES (22, 22.90 , 'P22', 2)");
        } catch (SQLException ex) {
            Logger.getLogger(DbappTest.class.getName()).log(Level.INFO, ex.getMessage());
        }        
    }

}