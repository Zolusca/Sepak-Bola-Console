package PapanSkor;

import KlubSepakBola.SepakBola;

import java.util.*;

public class PapanSkorImpl implements PapanSkor{
    private Map papanSkorLa_liga;

    public PapanSkorImpl() {
        papanSkorLa_liga = new HashMap<String,Integer>();
    }

    public void mulai(){
        updateDataPapanSkorLa_liga();
    }

    private void updateDataPapanSkorLa_liga() {
        int defaultPoint = 0;
        ArrayList<SepakBola> dataClubSepakBola = SepakBola.getListClubSepakBola();

        dataClubSepakBola
                .stream()
                // iterasi data papanSkor untuk insert data nama club baru
                .forEach(
                        sepakBola -> {
                            // jika tidak ada dalam papanSkor maka di tambahkan
                            if(!papanSkorLa_liga.containsKey(sepakBola.getNamaClub()))
                            {
                                // insert data club
                                papanSkorLa_liga.put(sepakBola.getNamaClub(),defaultPoint);
                            }
                });
    }

    @Override
    public void catatHasilPertandingan(SepakBola sepakBolaTandang, SepakBola sepakBolaKandang, String skor) {
        int[] pointSkor = olahDataSkorTanding(skor);

        papanSkorLa_liga.compute(sepakBolaTandang.getNamaClub(),
                                (key, value) -> Integer.valueOf((Integer) value)+ pointSkor[0]);
        papanSkorLa_liga.compute(sepakBolaKandang.getNamaClub(),
                                (key, value) -> Integer.valueOf((Integer) value)+ pointSkor[1]);

    }

    @Override
    public void cetakKlasemen() {
        List<Map.Entry<String, Integer>> list = new ArrayList<>(papanSkorLa_liga.entrySet());

        // Collection Entry untuk mengurutkan value dari HashMap
        Comparator<Map.Entry<String, Integer>> valueComparator = Map.Entry.comparingByValue();

        list.sort(valueComparator.reversed());

        // Menampilkan hasil sorting
        System.out.println("Rank Klasemen saat Ini");
        System.out.println("---------------------");
        System.out.println("[Nama Club]-----[Point]");
        System.out.println("---------------------");

        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        System.out.println("---------------------");
    }

    @Override
    public void getPointClub(SepakBola clubSepakBola) {
        System.out.println(papanSkorLa_liga.get(clubSepakBola.getNamaClub()));
    }

    private int[] olahDataSkorTanding(String skor) {
        int[] valueSkor = new int[2];
        String[] splitValue = skor.split(":");

        valueSkor[0] = Integer.parseInt(splitValue[0]);
        valueSkor[1] = Integer.parseInt(splitValue[1]);

        return valueSkor;
    }
}
