import java.util.ArrayList;

public class Televizyon {
    private String marka;
    private String boyut;
    private ArrayList <Kanal> kanallar;
    private boolean acik;
    private int ses;
    private int aktifKanal;

    public Televizyon(String marka,String boyut){
        this.marka = marka;
        this.boyut = boyut;
        kanallar = new ArrayList<>();
        kanallariOlustur();
        this.acik = false;
        this.ses = 10;
        this.aktifKanal = 1;
    }

    public String getMarka(){
        return marka;
    }

    public void setMarka(String marka){
        this.marka = marka;
    }

    public String getBoyut(){
        return boyut;
    }

    public void setBoyut(String boyut){
        this.boyut = boyut;
    }

    public void sesArttir(){
        if(ses < 20){
            if(acik){
                ses++;
                System.out.println("Ses seviyesi : " + ses);
            }else{
                System.out.println("TV kapalı !");
            }
        }else{
            System.out.println("Ses maksimum seviyede ! Daha fazla ses arttıramazsın.");
        }
    }

    public void sesAzalt(){
        if(ses > 0){
            if(acik){
                ses--;
                System.out.println("Ses seviyesi : " + ses);
            }else{
                System.out.println("TV kapalı !");
            }
        }else{
            System.out.println("Ses minimum seviyede ! Daha fazla ses azaltamazsın.");
        }
    }

    public void tvAc(){
        if(acik == false){
            acik = true;
            System.out.println("TV açıldı.");
        }else{
            System.out.println("TV zaten açık.");
        }
    }

    public void tvKapat(){
        if(acik == true){
            acik = false;
            System.out.println("TV kapatıldı.");
        }else{
            System.out.println("TV zaten kapalı.");
        }
    }

    private void kanallariOlustur() {
        HaberKanali cnn = new HaberKanali("CNN", 1, "Genel Haber");
        kanallar.add(cnn);
        HaberKanali beinSpor = new HaberKanali("Bein Spor", 2, "Spor Haber");
        kanallar.add(beinSpor);
        MuzikKanali dreamTurk = new MuzikKanali("Dream Türk", 3, "Yerli");
        kanallar.add(dreamTurk);
        MuzikKanali numberone = new MuzikKanali("Number One", 4, "Yabancı");
        kanallar.add(numberone);
    }

    public void kanalDegistir(int acilmasiIstenenKanal){
        if(acik){
            if(acilmasiIstenenKanal != aktifKanal){
                if(acilmasiIstenenKanal <= kanallar.size() && acilmasiIstenenKanal >=0){
                    aktifKanal = acilmasiIstenenKanal;
                    System.out.println("Kanal : " + acilmasiIstenenKanal + " \nBilgi: \n" + kanallar.get(aktifKanal-1).kanalBilgisiniGoster());
                }else{
                    System.out.println("Lütfen geçerli bir kanal giriniz.");
                }
            }else{
                System.out.println("\nZaten " + aktifKanal + " numaralı kanaldasınız. Kanal değiştirme işlemi yapılamadı.\n");
            }
        }else{
            System.out.println("Lütfen önce tv açma işlemini gerçekleştiriniz.");
        }
    }

    public void aktifKanaliGoster(){
        if(acik){
            System.out.println("Aktif kanal: \n" + kanallar.get(aktifKanal-1).kanalBilgisiniGoster());
        }else{
            System.out.println("Lütfen önce tv açma işlemini gerçekleştiriniz.");
        }
    }

    @Override
    public String toString(){
        return "\nMarka : " + marka + " Boyut : " + boyut + " olan tv oluşturuldu.\n";
    }
}