import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.LinkedList;
import java.util.List;

public class ReadWritePegawai {
    //Penggunaan List ditujukan agar dapat mengatasi perubahan size
    public static List<Pegawai> getPegawais(){
        List<Pegawai> result = new LinkedList<Pegawai>();
        try{
            BufferedReader reader = new BufferedReader(new FileReader("data_pegawai.txt"));
            while(reader.readLine() != null){
                try{
                    Pegawai temp = new Pegawai();
                    temp.SetId(reader.readLine());
                    temp.SetNama(reader.readLine());
                    temp.SetPassword(reader.readLine());

                    result.add(temp);
                }catch(Exception e){
                    reader.close();
                    e.printStackTrace();
                    break;
                }
            }
            reader.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public static void StoreAbsensi(String id, String nama, String waktu, String status){
        try{
            BufferedWriter out = new BufferedWriter(new FileWriter("riwayat.txt", true));
            out.newLine();
            out.write("#"); //Ini digunakan sebagai pembatas, agar file lebih mudah dibaca

            out.newLine();
            out.write("ID \t: "+id);

            out.newLine();
            out.write("Nama \t: "+nama);

            out.newLine();
            out.write("Waktu \t: "+waktu);

            out.newLine();
            out.write("Status \t:"+status);

            out.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
