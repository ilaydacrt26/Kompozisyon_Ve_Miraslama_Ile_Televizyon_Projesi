import java.util.Scanner;

public class Menu {

    static Scanner scanner = new Scanner(System.in);
    static Televizyon tv;

    public static void main(String[] args) {

        boolean cikis = false;

        while (!cikis) {
            System.out.print("\nSeçiminiz: (Menüyü görmek için 8'i tuşlayın.) : ");
            int secim = scanner.nextInt();

            switch (secim) {
                case 0:
                    System.out.println("\nSistemden çıkılıyor..");
                    cikis = true;
                    System.out.println("Sistemden çıkış yapıldı.\n");
                    break;
                case 1:
                    tvKurVeKanallariOlustur();
                case 2:
                    tvAc();
                    break;
                case 3:
                    sesArttir();
                    break;
                case 4:
                    sesAzalt();
                    break;
                case 5:
                    kanalDegistir();
                    break;
                case 6:
                    kanalBilgisiniGoster();
                    break;
                case 7:
                    tvKapat();
                    break;
                case 8:
                    menuGoster();
                    break;
                default:
                    System.out.println("Lütfen geçerli bir işlem giriniz");
                    break;
            }
        }
    }

    private static void kanalBilgisiniGoster() {
        if(tv != null){
            tv.aktifKanaliGoster();
        }else{
            System.out.println("Lütfen önce tv'yi kurun ve kanalları oluşturun.");
        }
    }

    private static void kanalDegistir() {
        if(tv != null){
            System.out.print("Kaç numaralı kanala gitmek istersiniz: ");
            int secim = scanner.nextInt();
            tv.kanalDegistir(secim);
        }else{
            System.out.println("Lütfen önce tv'yi kurun ve kanalları oluşturun.");
        }
    }

    private static void sesAzalt() {
        if(tv != null){
            tv.sesAzalt();
        }else{
            System.out.println("Lütfen önce tv'yi kurun ve kanalları oluşturun.");
        }
    }

    private static void sesArttir() {
        if(tv != null){
            tv.sesArttir();
        }else{
            System.out.println("Lütfen önce tv'yi kurun ve kanalları oluşturun.");
        }
    }

    private static void tvKapat() {
        if(tv != null){
            tv.tvKapat();
        }else{
            System.out.println("Lütfen önce tv'yi kurun ve kanalları oluşturun.");
        }
    }

    private static void tvAc() {
        if(tv != null){
            tv.tvAc();
        } else{
            System.out.println("Lütfen önce tv'yi kurun ve kanalları oluşturun.");
        }
    }

    private static void tvKurVeKanallariOlustur() {

        if (tv == null) {

            System.out.print("Televizyonun markasını giriniz: ");
            String marka = scanner.next();
            System.out.print("Televizyonun boyutunu girin: ");
            String boyut = scanner.next();

            tv = new Televizyon(marka, boyut);
            System.out.println(tv);
        }else{
            System.out.println(tv);
        }

    }

    private static void menuGoster() {

        System.out.println("""

                --------- MENU ---------

                    0 - Çıkış
                    1 - Televizyonu Kur
                    2 - Televizyonu Aç
                    3 - Televizyon Sesini Arttır
                    4 - Televizyon Sesini Azalt
                    5 - Kanal Değiştir
                    6 - Kanal Bilgisini Göster
                    7 - Televizyonu Kapat
                    8 - Menüyü Tekrar Göster
                    """);
    }
}