package PapanSkor;

import KlubSepakBola.SepakBola;

public interface PapanSkor {
    void cetakKlasemen();
    void getPointClub(SepakBola clubSepakBola);
    void catatHasilPertandingan(SepakBola sepakBolaTandang,SepakBola sepakBolaKandang, String skor);
}
