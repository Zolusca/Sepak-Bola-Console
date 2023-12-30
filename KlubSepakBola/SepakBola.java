package KlubSepakBola;

import java.util.ArrayList;
import java.util.Objects;

public abstract class SepakBola {
    protected static ArrayList<SepakBola> listClubSepakBola;
    protected String namaClub;

    public SepakBola() {
        this.listClubSepakBola = new ArrayList<>();
    }

    public static void tambahClubLa_liga(SepakBola clubSepakBola){
        // jika nama club duplikat
        if(cekDuplikatNamaClub(clubSepakBola.namaClub)){
            throw new IllegalArgumentException("nama club sudah terdaftar");
        }
        listClubSepakBola.add(clubSepakBola);
    }

    public static void tampilkanListClubLa_liga(){
        System.out.println("Daftar Club La liga");
        System.out.println("=====================");
        listClubSepakBola.forEach(dataClub -> System.out.println(dataClub.namaClub));
        System.out.println("=====================");
    }
    public static ArrayList<SepakBola> getListClubSepakBola(){
        return listClubSepakBola;
    }
    public static boolean cekDuplikatNamaClub(String nama){
        // jika array masih kosong
        if(listClubSepakBola.isEmpty()){
            return false;
        }
        // iterate data array
        for (SepakBola indexClub: listClubSepakBola) {
            if(indexClub.namaClub == nama){
                return true;
            }
        }

        return false;
    }

    public SepakBola setNamaClub(String namaClub) {
        this.namaClub = namaClub;
        return null;
    }

    public String getNamaClub() {
        return namaClub;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SepakBola sepakBola = (SepakBola) o;

        if (!Objects.equals(listClubSepakBola, sepakBola.listClubSepakBola))
            return false;
        return Objects.equals(namaClub, sepakBola.namaClub);
    }

    @Override
    public int hashCode() {
        int result = listClubSepakBola != null ? listClubSepakBola.hashCode() : 0;
        result = 31 * result + (namaClub != null ? namaClub.hashCode() : 0);
        return result;
    }
}
