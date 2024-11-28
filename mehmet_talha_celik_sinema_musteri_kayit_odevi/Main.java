import java.util.ArrayList;
import java.util.List;

// Temel sınıf (BaseEntity)
abstract class BaseEntity {
    protected int id;
    protected String name;

    public BaseEntity(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public abstract void bilgiGoster();
}

// Müşteri sınıfı
class Musteri extends BaseEntity {
    public Musteri(int id, String name) {
        super(id, name);
    }

    @Override
    public void bilgiGoster() {
        System.out.println("Müşteri ID: " + id + ", Ad: " + name);
    }
}

// Film sınıfı
class Film {
    private String ad;
    private String tur;
    private int sure;

    public Film(String ad, String tur, int sure) {
        this.ad = ad;
        this.tur = tur;
        this.sure = sure;
    }

    public String getAd() {
        return ad;
    }

    public void bilgiGoster() {
        System.out.println("Film Adı: " + ad + ", Tür: " + tur + ", Süre: " + sure + " dk");
    }
}

// Bilet sistemi için interface
interface IBiletSistemi {
    void musteriEkle(Musteri musteri);
    void filmEkle(Film film);
}

// Salon sınıfı
class Salon extends BaseEntity implements IBiletSistemi {
    private List<Musteri> musteriler;
    private Film film;

    public Salon(int id, String name) {
        super(id, name);
        this.musteriler = new ArrayList<>();
    }

    public void filmAyarla(Film film) {
        this.film = film;
    }

    @Override
    public void bilgiGoster() {
        System.out.println("Salon ID: " + id + ", Adı: " + name);
        if (film != null) {
            System.out.println("Gösterimdeki Film:");
            film.bilgiGoster();
        } else {
            System.out.println("Şu anda bu salonda film gösterimi yok.");
        }
    }

    @Override
    public void musteriEkle(Musteri musteri) {
        musteriler.add(musteri);
    }

    @Override
    public void filmEkle(Film film) {
        this.film = film;
    }

    public void musterileriListele() {
        System.out.println("Salon: " + name + " - Müşteri Listesi:");
        if (musteriler.isEmpty()) {
            System.out.println("Hiç müşteri yok.");
        } else {
            for (Musteri musteri : musteriler) {
                musteri.bilgiGoster();
            }
        }
    }
}
