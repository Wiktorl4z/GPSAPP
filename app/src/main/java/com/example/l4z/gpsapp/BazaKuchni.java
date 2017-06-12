package com.example.l4z.gpsapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BazaKuchni {

    private HashMap<Kuchnia,HashMap<Kwota,List<Restauracja>>> kuchnie = new HashMap<>();
    private static BazaKuchni instance = new BazaKuchni();

    private BazaKuchni() {
        this.instance = this;
        init();
        fillUp();
    }

    public static BazaKuchni getInstance() {
        return instance;
    }

    private void init(){
        for (Kuchnia k:Kuchnia.values()
             ) {
            HashMap<Kwota,List< Restauracja>> kwoty = new HashMap<>();
            for (Kwota w: Kwota.values()
                 ) {
                kwoty.put(w, new ArrayList<Restauracja>());
            }
            kuchnie.put(k, kwoty);
        }
    }

    /*map.addMarker(new MarkerOptions()
    .title("Sydney")
    .snippet("The most populous city in Australia.")
    .position(sydney));*/

    private void fillUp(){
        stworzRestauracje("Pyzata Chata",51.245482, 22.555899,Kuchnia.POLSKA,Kwota.K10);
        stworzRestauracje("Lanczomania",51.235072, 22.547164,Kuchnia.POLSKA,Kwota.K10);
        stworzRestauracje("KANAPKI I DODATK",51.247782, 22.562326,Kuchnia.POLSKA,Kwota.K10);
        stworzRestauracje("Koper Włoski U Braci Mazur",51.237316, 22.548427,Kuchnia.POLSKA,Kwota.K20);
        stworzRestauracje("Czarcia Łapa",51.24788, 22.567227,Kuchnia.POLSKA,Kwota.K30);
        stworzRestauracje("Mandragora",51.248057, 22.568472,Kuchnia.POLSKA,Kwota.K50);
        stworzRestauracje("Restauracja Kardamon",51.247973, 22.561209,Kuchnia.POLSKA,Kwota.K50);
        stworzRestauracje("Chata Swojsko Strawa",51.237997, 22.55116,Kuchnia.POLSKA,Kwota.K50);

        stworzRestauracje("Santos Caffe",51.24879, 22.568733,Kuchnia.WLOSKA,Kwota.K10);
        stworzRestauracje("Ostro Klubokawiarnia",51.247756, 22.563178,Kuchnia.WLOSKA,Kwota.K10);
        stworzRestauracje("Sexy Duck",51.248495, 22.562617,Kuchnia.WLOSKA,Kwota.K20);
        stworzRestauracje("OTO IVO",51.247632, 22.568493,Kuchnia.WLOSKA,Kwota.K20);
        stworzRestauracje("Szkatuła",51.245054, 22.559492,Kuchnia.WLOSKA,Kwota.K20);
        stworzRestauracje("Rynek 5",51.248151, 22.567587,Kuchnia.WLOSKA,Kwota.K30);
        stworzRestauracje("Viva La Pizza",51.247514, 22.563545,Kuchnia.WLOSKA,Kwota.K30);
        stworzRestauracje("Trattoria Bagatto",51.246334, 22.5608,Kuchnia.WLOSKA,Kwota.K50);
        stworzRestauracje("Dolce Vita",51.247782, 22.562326,Kuchnia.WLOSKA,Kwota.K50);

        stworzRestauracje("Hades Szeroka",51.247627, 22.554411,Kuchnia.BBQ,Kwota.K20);
        stworzRestauracje("Red Rock City",51.246023, 22.549141,Kuchnia.BBQ,Kwota.K20);
        stworzRestauracje("KARCZMA POD STRZECHĄ",51.235905, 22.537198,Kuchnia.BBQ,Kwota.K30);

        stworzRestauracje("Bar Sajgon",51.234068, 22.543444,Kuchnia.JAPONSKA,Kwota.K10);
        stworzRestauracje("Eat&Go",51.250615, 22.535445,Kuchnia.JAPONSKA,Kwota.K10);
        stworzRestauracje("Pałeczkami Sushi",51.248554, 22.553204,Kuchnia.JAPONSKA,Kwota.K20);
        stworzRestauracje("Kobi Sushi",51.246785, 22.55992,Kuchnia.JAPONSKA,Kwota.K20);
        stworzRestauracje("Takami Sushi",51.245298, 22.555601,Kuchnia.JAPONSKA,Kwota.K30);

    }

    private void stworzRestauracje(String nazwa, double szerokosc, double wysokosc, Kuchnia kuchnia, Kwota kwota) {
        kuchnie.get(kuchnia).get(kwota).add(new Restauracja(nazwa, szerokosc, wysokosc ));
    }

    public List<Restauracja> getRestauracja(Kwota kwota, Kuchnia kuchnia) {
        if(kwota == null || kuchnia == null){
            throw new NullPointerException("Kwota lub kuchnia jest nullem");
        }
        return kuchnie.get(kuchnia).get(kwota);
    }
}
