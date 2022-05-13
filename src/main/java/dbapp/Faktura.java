package dbapp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "faktura")
public class Faktura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String zakaznik;

    @OneToMany
    @JoinColumn(name = "FAKTURA_ID")
    private List<Polozka> polozky;

    public Faktura() {
        polozky = new ArrayList<>();
    }

    public List<Polozka> getPolozky() {
        return polozky;
    }

    public void setPolozky(List<Polozka> polozky) {
        this.polozky = polozky;
    }

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date aktualizacia;

    public Date getAktualizacia() {
        return aktualizacia;
    }

    public void setAktualizacia(Date aktualizacia) {
        this.aktualizacia = aktualizacia;
    }

    public String getZakaznik() {
        return zakaznik;
    }

    public void setZakaznik(String zakaznik) {
        this.zakaznik = zakaznik;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
//        int hash = 0;
//        hash += (id != null ? id.hashCode() : 0);
        return id;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Faktura)) {
            return false;
        }
        Faktura other = (Faktura) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Faktura[ id=" + id + " ]";
    }

}
