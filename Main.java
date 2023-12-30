

// TODO Program latihan

import KlubSepakBola.SepakBola;
import KlubSepakBola.SepakBolaAsia;
import KlubSepakBola.SepakBolaEropa;
import KlubSepakBola.SepakBolaFactory;
import PapanSkor.PapanSkor;
import PapanSkor.PapanSkorImpl;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        PapanSkorImpl papanSkor = new PapanSkorImpl();

        SepakBolaEropa Madrid   = SepakBolaFactory.instanceOfSepakBolaEropa()
                                                    .setNamaClub("Madrid");
        SepakBolaAsia Indonesia = SepakBolaFactory.instanceOfSepakBolaAsia()
                                                    .setNamaClub("indonesia");
        SepakBolaAsia Malaysia  = SepakBolaFactory.instanceOfSepakBolaAsia()
                                                    .setNamaClub("Malaysia");
        SepakBolaEropa Germany  = SepakBolaFactory.instanceOfSepakBolaEropa()
                                                    .setNamaClub("Germany");

        SepakBola.tambahClubLa_liga(Madrid);
        SepakBola.tambahClubLa_liga(Germany);
        SepakBola.tambahClubLa_liga(Malaysia);
        SepakBola.tambahClubLa_liga(Indonesia);
        // menampilkan daftar list club la liga
        SepakBola.tampilkanListClubLa_liga();

        papanSkor.mulai();
        papanSkor.catatHasilPertandingan(Madrid,Indonesia,"2:3");
        papanSkor.catatHasilPertandingan(Malaysia,Indonesia,"1:2");
        papanSkor.catatHasilPertandingan(Madrid,Germany,"2:2");
        papanSkor.cetakKlasemen();
    }
}