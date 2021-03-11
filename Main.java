import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Main {
	
    static Scanner key;
    static ArrayList<Karyawan> dataKaryawan;
    public static final String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String digits = "0123456789";
    static Random random;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        key = new Scanner(System.in);
        random = new Random();
        dataKaryawan = new ArrayList<>();

        while(true){
            System.out.println("1. Insert Data Karyawan");
            System.out.println("2. View Data Karyawan");
            System.out.println("3. Update Data Karyawan");
            System.out.println("4. Delete Data Karyawan");
            System.out.print("Masukkan pilihan : ");
            int pilihan = Integer.parseInt(key.nextLine());
            switch (pilihan) {
                case 1:
                    String kode = kodeKaryawan();
                    String nama = "", jk = "", jabatan = "";
                    int gaji = 0;
                    double persen = 0.0;
                    while(true){
                        System.out.print("Input nama karyawan [>= 3] : ");
                        nama = key.nextLine();
                        if(nama.length() >= 3){
                            break;
                        }
                    }   
                    while(true){
                        System.out.print("Input jenis kelamin [Laki-laki | Perempuan] (Case Sensitive) : ");
                        jk = key.nextLine();
                        if(jk.equals("Laki-laki")){
                            break;
                        }else if(jk.equals("Perempuan")){
                            break;
                        }
                    }   
                    while(true){
                        System.out.print("Input jabatan [Manager | Supervisor | Admin] (Case Sensitive) : ");
                        jabatan = key.nextLine();
                        if(jabatan.equals("Manager")){
                            gaji = 8000000;
                            persen = 10;
                            break;
                        }else if(jabatan.equals("Supervisor")){
                            gaji = 6000000;
                            persen = 7.5;
                            break;
                        }else if(jabatan.equals("Admin")){
                            gaji = 4000000;
                            persen = 5;
                            break;
                        }
                    }
                    dataKaryawan.add(new Karyawan(kode, nama, jk, jabatan, gaji));
                    System.out.println("Berhasil menambahkan Karyawan dengan id " + kode);
                    if(dataKaryawan.size() > 0){
                        int totalJabatan = 0;
                        for (int i = 0; i < dataKaryawan.size(); i++) {
                            if(dataKaryawan.get(i).getJabatan().equals(jabatan)){
                                totalJabatan++;
                            }
                        }
                        int jumlahKaryawan = totalJabatan - 1;
                        int penguranganKaryawan = 0;
                        if(totalJabatan > 3){
                         if(jumlahKaryawan % 3 == 0){
                         System.out.print("Bonus sebesar " + persen + "% telah diberikan kepada karyawan dengan id");
                         for (int i = 0; i < dataKaryawan.size(); i++) {
                         if(dataKaryawan.get(i).getJabatan().equals(jabatan)){
                          if(penguranganKaryawan < jumlahKaryawan){
                          if(penguranganKaryawan == 0){
                          System.out.print(" " + dataKaryawan.get(i).getKode());
                            }else{
                           System.out.print(", " + dataKaryawan.get(i).getKode());
                                            }
                           double tambahan = dataKaryawan.get(i).getGaji() * (persen / 100);
                           dataKaryawan.get(i).setGaji(dataKaryawan.get(i).getGaji() + (int)tambahan);
                           penguranganKaryawan++;
                         }
                       }
                     }
                   }
                 }
              }
                    System.out.println("\n");
                    break;
                case 2:
                    Collections.sort(dataKaryawan, Karyawan.KaryawanNameComparator);
                    if(dataKaryawan.size() > 0){
                        System.out.println("|----|-----------------|--------------------------------|---------------|-----------------|---------------|");
                        System.out.println("|No  |Kode Karyawan    |Nama Karyawan                   |Jenis Kelamin  |Jabatan          |Gaji Karyawan  |");
                        System.out.println("|----|-----------------|--------------------------------|---------------|-----------------|---------------|");
                        for (int i = 0; i < dataKaryawan.size(); i++) {
                            System.out.printf("|%4d|%17s|%32s|%15s|%17s|%15s|\n", (i+1), 
                                    dataKaryawan.get(i).getKode(), 
                                    dataKaryawan.get(i).getNama(), 
                                    dataKaryawan.get(i).getJenis_kelamin(), 
                                    dataKaryawan.get(i).getJabatan(), 
                                    dataKaryawan.get(i).getGaji());
                        }
                        System.out.println("|----|-----------------|--------------------------------|---------------|-----------------|---------------|");
                    }
                    System.out.println("");
                    break;
                case 3:
                    Collections.sort(dataKaryawan, Karyawan.KaryawanNameComparator);
                    if(dataKaryawan.size() > 0){
                        System.out.println("|----|-----------------|--------------------------------|---------------|-----------------|---------------|");
                        System.out.println("|No  |Kode Karyawan    |Nama Karyawan                   |Jenis Kelamin  |Jabatan          |Gaji Karyawan  |");
                        System.out.println("|----|-----------------|--------------------------------|---------------|-----------------|---------------|");
                        for (int i = 0; i < dataKaryawan.size(); i++) {
                            System.out.printf("|%4d|%17s|%32s|%15s|%17s|%15s|\n", (i+1), 
                                    dataKaryawan.get(i).getKode(), 
                                    dataKaryawan.get(i).getNama(), 
                                    dataKaryawan.get(i).getJenis_kelamin(), 
                                    dataKaryawan.get(i).getJabatan(), 
                                    dataKaryawan.get(i).getGaji());
                        }
                        System.out.println("|----|-----------------|--------------------------------|---------------|-----------------|---------------|");
                    }
                    System.out.print("Masukkan Nomor yang akan diubah : ");
                    int nomor = Integer.parseInt(key.nextLine());
                    if(nomor > 0){
                        if(nomor <= dataKaryawan.size()){
                            String ukode = kodeKaryawan();
                            String unama = "", ujk = "", ujabatan = "";
                            int ugaji = 0;
                            while(true){
                                System.out.print("Input nama karyawan [>= 3] : ");
                                unama = key.nextLine();
                                if(unama.length() >= 3){
                                    break;
                                }
                            }   
                            while(true){
                                System.out.print("Input jenis kelamin [Laki-laki | Perempuan] (Case Sensitive) : ");
                                ujk = key.nextLine();
                                if(ujk.equals("Laki-laki")){
                                    break;
                                }else if(ujk.equals("Perempuan")){
                                    break;
                                }
                            }   
                            while(true){
                                System.out.print("Input jabatan [Manager | Supervisor | Admin] (Case Sensitive) : ");
                                ujabatan = key.nextLine();
                                if(ujabatan.equals("Manager")){
                                    ugaji = 8000000;
                                    break;
                                }else if(ujabatan.equals("Supervisor")){
                                    ugaji = 6000000;
                                    break;
                                }else if(ujabatan.equals("Admin")){
                                    ugaji = 4000000;
                                    break;
                                }
                            }
                            dataKaryawan.get(nomor-1).setKode(ukode);
                            dataKaryawan.get(nomor-1).setNama(unama);
                            dataKaryawan.get(nomor-1).setJenis_kelamin(ujk);
                            dataKaryawan.get(nomor-1).setJabatan(ujabatan);
                            dataKaryawan.get(nomor-1).setGaji(ugaji);
                            System.out.println("Berhasil merubah data Karyawan, id baru karyawan adalah " + ukode);
                        }else{
                            System.out.println("Nomor tidak tersedia.");
                        }
                    }else{
                        System.out.println("Nomor tidak tersedia.");
                    }
                    break;
                case 4:
                    Collections.sort(dataKaryawan, Karyawan.KaryawanNameComparator);
                    if(dataKaryawan.size() > 0){
                        System.out.println("|----|-----------------|--------------------------------|---------------|-----------------|---------------|");
                        System.out.println("|No  |Kode Karyawan    |Nama Karyawan                   |Jenis Kelamin  |Jabatan          |Gaji Karyawan  |");
                        System.out.println("|----|-----------------|--------------------------------|---------------|-----------------|---------------|");
                        for (int i = 0; i < dataKaryawan.size(); i++) {
                            System.out.printf("|%4d|%17s|%32s|%15s|%17s|%15s|\n", (i+1), 
                                    dataKaryawan.get(i).getKode(), 
                                    dataKaryawan.get(i).getNama(), 
                                    dataKaryawan.get(i).getJenis_kelamin(), 
                                    dataKaryawan.get(i).getJabatan(), 
                                    dataKaryawan.get(i).getGaji());
                        }
                        System.out.println("|----|-----------------|--------------------------------|---------------|-----------------|---------------|");
                    }
                    System.out.print("Masukkan Nomor yang akan diubah : ");
                    int nomordelete = Integer.parseInt(key.nextLine());
                    if(nomordelete > 0){
                        if(nomordelete <= dataKaryawan.size()){
                            dataKaryawan.remove(nomordelete-1);
                        }else{
                            System.out.println("Nomor tidak tersedia.");
                        }
                    }else{
                        System.out.println("Nomor tidak tersedia.");
                    }
                    break;
                default:
                    System.out.println("Pilihan tidak tersedia.");
                    break;
            }
        }
    }

    public static int randomUpper(){
        return random.nextInt(upper.length() - 1) + 1;
    }

    public static int randomDigits(){
        return random.nextInt(digits.length() - 1) + 1;
    }
    
    public static String kodeKaryawan(){
        StringBuilder kode = new StringBuilder();
        kode.append(upper.charAt(randomUpper()));
        kode.append(upper.charAt(randomUpper()));
        kode.append("-");
        kode.append(digits.charAt(randomDigits()));
        kode.append(digits.charAt(randomDigits()));
        kode.append(digits.charAt(randomDigits()));
        return kode.toString();
    }
}