package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.TimeZone;

public class Program {
    public static void main(String[] args) throws ParseException {

        // Cria um formatador de datas para alguns padrões que são passados por parâmetro.
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        SimpleDateFormat sdf3 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        sdf3.setTimeZone(TimeZone.getTimeZone("GMT"));

        // Cria uma data no instante atual.
        Date data = new Date();

        // Cria uma data no padrão UTC
        Date data2 = Date.from(Instant.parse("2021-05-17T09:45:32Z"));
        System.out.println(sdf3.format(data2));

        // Cria datas de acordo com algum texto passado.
        Date y1 = sdf1.parse("20/02/2023");
        Date y2 = sdf2.parse("20/02/2023 18:30:22");

        // Data inicial do Java
        Date x1 = new Date(System.currentTimeMillis());
        System.out.println(sdf2.format(x1));
        Date x2 = new Date(0L);
        System.out.println(sdf2.format(x2));
        Date x3 = new Date(1000L * 60L * 60L * 5L);
        System.out.println(sdf2.format(x3));

        // Usa o formatador criado para formatar uma data tipo texto.
        System.out.println(sdf2.format(data));
        System.out.println(sdf1.format(y1));
        System.out.println(sdf2.format(y2));

        System.out.println(y1);
        System.out.println(y2);
    }
}
