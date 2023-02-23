import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.Entidade;

public class App {
    public static void main(String[] args) {

        String fileName = "LOG_1.log";

        System.out.println();
        System.out.println("---------------------------------------------");
        System.out.println();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            String line;
            String inicioTabela = "Alarm Serial No  Sync No  Parent Serial No  Subnet ID  Managed Element ID  1Managed Element Type  Alarm ID  Alarm Name";
            String finalTabela = "(Number of results =";

            boolean ler = false;

            List<String> linhasTabela = new ArrayList<>();

            while ((line = br.readLine()) != null) {

                if (line.replaceAll(" ", "").equals(inicioTabela.replaceAll(" ", ""))) {
                    ler = true;
                } else if (line.replaceAll(" ", "").contains(finalTabela.replaceAll(" ", ""))) {
                    ler = false;
                }

                if (ler && !line.isBlank()) {
                    linhasTabela.add(line);
                }

            }

            String cabecalhoTabela = linhasTabela.get(0);

            Pattern pattern = Pattern.compile(" {2,}[A-Za-z0-9]");
            Matcher matcher = pattern.matcher(cabecalhoTabela);
            List<Integer> indices = new ArrayList<>();
            while (matcher.find()) {
                int index = matcher.start() + matcher.group().length() - 1;
                indices.add(index);
            }

            linhasTabela.remove(0);
            linhasTabela.forEach(linha -> {
                Entidade entidade = new Entidade();

                entidade.setAlarmSerialNo(linha.substring(0, (indices.get(0) - 1)).trim());
                entidade.setSyncNo(linha.substring(indices.get(0), (indices.get(1) - 1)).trim());
                entidade.setParentSerialNo(linha.substring(indices.get(1), (indices.get(2) - 1)).trim());
                entidade.setSubnetId(linha.substring(indices.get(2), (indices.get(3) - 1)).trim());
                entidade.setManagedElementId(linha.substring(indices.get(3), (indices.get(4) - 1)).trim());
                entidade.setManagedElementType(linha.substring(indices.get(4), (indices.get(5) - 1)).trim());
                entidade.setAlarmId(linha.substring(indices.get(5), (indices.get(6) - 1)).trim());
                entidade.setAlarmName(linha.substring(indices.get(6), linha.length()).trim());

                System.out.println(entidade);
            });

            System.out.println();
            System.out.println("---------------------------------------------");
            System.out.println();

        } catch (IOException e) {
            System.out.println("Error reading file '" + fileName + "': " + e.getMessage());
        }

    }

}
