Sinema Müşteri Kayıt Sistemi
Bu proje, bir sinema işletmesi için müşteri, film ve salon kayıtlarının yönetilebildiği bir Java console uygulamasıdır. Proje, aşağıdaki özelliklere sahip olacak şekilde tasarlanmıştır.

Projenin Özellikleri
Müşteri Yönetimi:

Yeni müşteri eklenebilir.
Salonlara müşteriler atanabilir.
Film Yönetimi:

Yeni filmler eklenebilir.
Filmler ve gösterildikleri salonlar listelenebilir.
Salon Yönetimi:

Yeni salonlar eklenebilir.
Salonlarda oynatılan filmler görüntülenebilir.
Salonlara kayıtlı müşteriler listelenebilir.
Teknik Detaylar
1. Kullanılan Sınıflar
BaseEntity: Ortak özelliklerin (id ve name) tanımlandığı soyut (abstract) temel sınıf.
Musteri: BaseEntity sınıfından türetilmiştir. Müşteri bilgilerini içerir.
Film: Film adını, türünü ve süresini tutar.
Salon: BaseEntity sınıfından türetilmiştir. Gösterilen filmi ve kayıtlı müşteri listesini içerir.
2. Interface Kullanımı
IBiletSistemi:
musteriEkle(Musteri musteri) ve filmEkle(Film film) metotlarını içerir.
Salon sınıfı bu interface'i uygular.
3. Polymorphism
BaseEntity sınıfındaki bilgiGoster() metodu türetilmiş sınıflarda (Musteri ve Salon) özelleştirilmiştir.
Konsol Üzerinden Gerçekleştirilebilecek İşlemler
Yeni Müşteri Ekle: Sisteme yeni müşteri kaydedilir.
Yeni Film Ekle: Sisteme yeni bir film kaydedilir.
Yeni Salon Ekle: Sisteme yeni bir salon kaydedilir.
Filmleri Listele: Eklenen tüm filmleri ve detaylarını görüntüler.
Salon Bilgisi Göster: Tüm salonların bilgilerini ve oynatılan filmleri gösterir.
Salona Müşteri Ekle: Bir müşteriyi seçilen salona kaydeder.
Salonun Müşteri Listesini Göster: Seçilen salona kayıtlı tüm müşterileri listeler.
Çıkış: Uygulamadan çıkılır.
