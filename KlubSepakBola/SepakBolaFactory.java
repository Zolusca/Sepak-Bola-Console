package KlubSepakBola;

public class SepakBolaFactory {
    public static SepakBolaAsia instanceOfSepakBolaAsia(){
        return new SepakBolaAsia();
    }

    public static SepakBolaEropa instanceOfSepakBolaEropa(){
        return new SepakBolaEropa();
    }

}
