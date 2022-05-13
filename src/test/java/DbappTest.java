import dbapp.Dbapp;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
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
        try {
            prepareTables();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.print(START_TESTS_IDENTIFIER);
    }

    @AfterAll
    static void afterAll() {
        System.out.print(END_TESTS_IDENTIFIER);
    }

    private static ResultSet rs = null;

    // POCET
    @Test
    @Order(1)
    public void UT01pocet_3b() {
        TestResult tr = new TestResult();
        tr.setTestIdentifier("UT01pocet_3b");
        tr.setNumberOfPoints(3);

        tr.setExpectedValue("1, 2");

        int r1 = -1;
        int r2 = -1;

        try {
            r1 = Dbapp.pocetFaktur("Z1");
            r2 = Dbapp.pocetFaktur("Z2");

            tr.setActualValue(r1 + ", " + r2);

            tr.setTestResult((r1 == 1 && r2 == 2) ? TestResultTypeEnu.CORRECT : TestResultTypeEnu.FAIL);

        } catch (Exception e) {
            tr.setTestResult(TestResultTypeEnu.FAIL);
            tr.setDetails(e.getMessage());
        }

        System.out.println(tr);
    }

    @Test
    @Order(2)
    public void UT02pocet_2b() {
        TestResult tr = new TestResult();
        tr.setTestIdentifier("UT02pocet_2b");
        tr.setNumberOfPoints(2);

        tr.setExpectedValue("0");

        int r3 = -1;
        try {
            r3 = Dbapp.pocetFaktur("Z3");
            tr.setActualValue("" + r3);

            tr.setTestResult(r3 == 0 ? TestResultTypeEnu.CORRECT : TestResultTypeEnu.FAIL);

        } catch (Exception e) {
            tr.setTestResult(TestResultTypeEnu.FAIL);
            tr.setDetails(e.getMessage());
        }

        System.out.println(tr);
    }

    // PRIDAJ
    // do 1 (mala 2)
    // do 3 (mala 0)
    // do 4 (neexistuje)
    @Test
    @Order(3)
    public void UT03pridaj_2b() {
        TestResult tr = new TestResult();
        tr.setTestIdentifier("UT03pridaj_2b");
        tr.setNumberOfPoints(2);

        tr.setExpectedValue("volanie prejde bez chyby");

        int r = -1;
        try {
            Dbapp.pridajPolozku(1, "pivo", 2.0);
            Dbapp.pridajPolozku(3, "pivo", 1.5);

            tr.setActualValue("volanie preslo bez chyby");

            tr.setTestResult(TestResultTypeEnu.CORRECT);

        } catch (Exception e) {
            tr.setTestResult(TestResultTypeEnu.FAIL);
            tr.setDetails(e.getMessage());
        }

        System.out.println(tr);
    }

    @Test
    @Order(4)
    public void UT04pridaj4_2n() {
        TestResult tr = new TestResult();
        tr.setTestIdentifier("UT04pridaj4_2n");
        tr.setNumberOfPoints(2);

        tr.setExpectedValue("volanie prejde bez chyby");

        int r = -1;
        try {
            Dbapp.pridajPolozku(4, "pivo", 2.0);

            tr.setActualValue("volanie preslo bez chyby");

            tr.setTestResult(TestResultTypeEnu.CORRECT);

        } catch (Exception e) {
            tr.setTestResult(TestResultTypeEnu.FAIL);
            tr.setDetails(e.getMessage());
        }

        System.out.println(tr);
    }

    // kontrola aktualizacie
    @Test
    @Order(5)
    public void UT05date_1b() {
        TestResult tr = new TestResult();
        tr.setTestIdentifier("UT05date_1b");
        tr.setNumberOfPoints(1);

        tr.setExpectedValue("notNull, null");

        String d1 = null;
        String d2 = null;
        try (Connection con = DriverManager.getConnection(DB_URL, "postgres", "postgres")) {
            Statement st = con.createStatement();
            rs = st.executeQuery("SELECT aktualizacia FROM FAKTURA WHERE id=1");
            rs.next();
            d1 = rs.getString("AKTUALIZACIA");

            rs = st.executeQuery("SELECT aktualizacia FROM FAKTURA WHERE id=2");
            rs.next();
            d2 = rs.getString("AKTUALIZACIA");

            tr.setTestResult((d1 != null && d2 == null) ? TestResultTypeEnu.CORRECT : TestResultTypeEnu.FAIL);

            tr.setActualValue(d1 + ", " + d2);

        } catch (SQLException ex) {
            tr.setTestResult(TestResultTypeEnu.FAIL);
            tr.setDetails(ex.getMessage());
        }

        System.out.println(tr);
    }


    // kontroly
    // 1 pocet poloziek = 3
    // 3 pocet poloziek = 1
    // 3 cena 1. polozky = 1.5
    @Test
    @Order(6)
    public void UT06pocetpol_1b() {
        TestResult tr = new TestResult();
        tr.setTestIdentifier("UT06pocetpol_1b");
        tr.setNumberOfPoints(1);

        tr.setExpectedValue("3");

        int n = 0;
        try (Connection con = DriverManager.getConnection(DB_URL, "postgres", "postgres")) {
            Statement st = con.createStatement();
            rs = st.executeQuery("SELECT count(*) FROM POLOZKA WHERE FAKTURA_ID=1");
            rs.next();
            n = rs.getInt(1);

            tr.setActualValue("" + n);

            tr.setTestResult(n == 3 ? TestResultTypeEnu.CORRECT : TestResultTypeEnu.FAIL);

        } catch (SQLException ex) {
            tr.setTestResult(TestResultTypeEnu.FAIL);
            tr.setDetails(ex.getMessage());
        }

        System.out.println(tr);
    }

    @Test
    @Order(7)
    public void testForcedToBeWrong() {
        TestResult tr = new TestResult();
        tr.setTestIdentifier("testForcedToBeWrong");
        tr.setNumberOfPoints(0);

        tr.setExpectedValue("2");

        int n = 0;
        try (Connection con = DriverManager.getConnection(DB_URL, "postgres", "postgres")) {
            Statement st = con.createStatement();
            rs = st.executeQuery("SELECT count(*) FROM test_table");
            rs.next();
            n = rs.getInt(1);

            tr.setActualValue("" + n);

            tr.setTestResult(n == 2 ? TestResultTypeEnu.CORRECT : TestResultTypeEnu.FAIL);

        } catch (SQLException ex) {
            tr.setTestResult(TestResultTypeEnu.FAIL);
            tr.setDetails(ex.getMessage());
        }

        System.out.println(tr);
    }

    static private void prepareTables() throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");

        try (Connection con = DriverManager.getConnection(DB_URL, "postgres", "postgres")) {
            Statement st = con.createStatement();
            st.execute("CREATE TABLE test_table (code char(5), title varchar(40));");
            st.executeUpdate("insert into test_table(code, title) values ('aa', 'title')");
            st.executeUpdate("insert into test_table(code, title) values ('bb', 'title2')");
            st.executeUpdate("insert into test_table(code, title) values ('cc', 'title3')");

            st.execute("CREATE TABLE faktura(id integer PRIMARY KEY, zakaznik char(255), aktualizacia date);");
            st.execute("CREATE TABLE polozka(id integer PRIMARY KEY, produkt char(255), cena real, faktura_id integer REFERENCES faktura (id));");

            st.executeUpdate("INSERT INTO faktura(id, aktualizacia, zakaznik) VALUES (1, NULL, 'Z1')");
            st.executeUpdate("INSERT INTO faktura(id, aktualizacia, zakaznik) VALUES (2, NULL, 'Z2')");
            st.executeUpdate("INSERT INTO faktura(id, aktualizacia, zakaznik) VALUES (3, NULL, 'Z2')");
            st.executeUpdate("INSERT INTO polozka(id, cena, produkt, faktura_id) VALUES (11, 11.90 , 'P11', 1)");
            st.executeUpdate("INSERT INTO polozka(id, cena, produkt, faktura_id) VALUES (12, 21.90 , 'P12', 1)");
            st.executeUpdate("INSERT INTO polozka(id, cena, produkt, faktura_id) VALUES (22, 22.90 , 'P22', 2)");

        } catch (SQLException ex) {
            Logger.getLogger(DbappTest.class.getName()).log(Level.INFO, ex.getMessage());
        }
    }

}
