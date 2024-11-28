import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;


public class SinemaSistemi {
    private static List<Salon> salonlar = new ArrayList<>();
    private static List<Film> filmler = new ArrayList<>();
    private static List<Musteri> musteriler = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean devam = true;

        while (devam) {
            System.out.println("\n=== Sinema Müşteri Kayıt Sistemi ===");
            System.out.println("1. Yeni Müşteri Ekle");
            System.out.println("2. Yeni Film Ekle");
            System.out.println("3. Yeni Salon Ekle");
            System.out.println("4. Filmleri Listele");
            System.out.println("5. Salon Bilgisi Göster");
            System.out.println("6. Salona Müşteri Ekle");
            System.out.println("7. Salonun Müşteri Listesini Göster");
            System.out.println("0. Çıkış");
            System.out.print("Seçiminiz: ");

            int secim = scanner.nextInt();
            scanner.nextLine(); // Yeni satırı temizle

            switch (secim) {
                case 1:
                    yeniMusteriEkle();
                    break;
                case 2:
                    yeniFilmEkle();
                    break;
                case 3:
                    yeniSalonEkle();
                    break;
                case 4:
                    filmleriListele();
                    break;
                case 5:
                    salonBilgisiGoster();
                    break;
                case 6:
                    salonaMusteriEkle();
                    break;
                case 7:
                    salonunMusterileriniGoster();
                    break;
                case 0:
                    devam = false;
                    break;
                default:
                    System.out.println("Geçersiz seçim! Lütfen tekrar deneyin.");
            }
        }
        System.out.println("Sistem kapatıldı.");
    }

    private static void yeniMusteriEkle() {
        System.out.print("Müşteri Adı: ");
        String ad = scanner.nextLine();
        Musteri musteri = new Musteri(musteriler.size() + 1, ad);
        musteriler.add(musteri);
        System.out.println("Yeni müşteri eklendi.");
    }

    private static void yeniFilmEkle() {
        System.out.print("Film Adı: ");
        String ad = scanner.nextLine();
        System.out.print("Film Türü: ");
        String tur = scanner.nextLine();
        System.out.print("Film Süresi (dakika): ");
        int sure = scanner.nextInt();
        scanner.nextLine(); // Yeni satırı temizle
        Film film = new Film(ad, tur, sure);
        filmler.add(film);
        System.out.println("Yeni film eklendi.");
    }

    private static void yeniSalonEkle() {
        System.out.print("Salon Adı: ");
        String ad = scanner.nextLine();
        Salon salon = new Salon(salonlar.size() + 1, ad);
        salonlar.add(salon);
        System.out.println("Yeni salon eklendi.");
    }

    private static void filmleriListele() {
        if (filmler.isEmpty()) {
            System.out.println("Kayıtlı film yok.");
        } else {
            for (Film film : filmler) {
                film.bilgiGoster();
            }
        }
    }

    private static void salonBilgisiGoster() {
        for (Salon salon : salonlar) {
            salon.bilgiGoster();
        }
    }

    private static void salonaMusteriEkle() {
        System.out.print("Salon ID: ");
        int salonId = scanner.nextInt();
        scanner.nextLine(); // Yeni satırı temizle
        System.out.print("Müşteri ID: ");
        int musteriId = scanner.nextInt();
        scanner.nextLine(); // Yeni satırı temizle

        if (salonId > 0 && salonId <= salonlar.size() && musteriId > 0 && musteriId <= musteriler.size()) {
            Salon salon = salonlar.get(salonId - 1);
            Musteri musteri = musteriler.get(musteriId - 1);
            salon.musteriEkle(musteri);
            System.out.println("Müşteri salona eklendi.");
        } else {
            System.out.println("Geçersiz ID.");
        }
    }

    private static void salonunMusterileriniGoster() {
        System.out.print("Salon ID: ");
        int salonId = scanner.nextInt();
        scanner.nextLine(); // Yeni satırı temizle

        if (salonId > 0 && salonId <= salonlar.size()) {
            Salon salon = salonlar.get(salonId - 1);
            salon.musterileriListele();
        } else {
            System.out.println("Geçersiz salon ID.");
        }
    }
}
