package view;
import model.Mail;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class MailListReader {
    public static List<Mail> read(String fileName){
        List<Mail> lista = new ArrayList<>();
        try{
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            Pattern patron = Pattern.compile("[A-Za-z0-9.]+@\\w+(.\\w+)+");
            Matcher buscar;
            while ((linea = br.readLine()) != null){
                buscar = patron.matcher(linea);
                if (buscar.find()) {
                    Mail mail = new Mail(buscar.group());
                    lista.add(mail);
                }
            }
            fr.close();
        } catch (Exception e){
        }
        return lista;
    }
}
