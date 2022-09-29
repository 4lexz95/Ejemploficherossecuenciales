package ficherosdeobjetos;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class ficherosObjetos{
    private static ArrayList<dado> dados;
    private static File dadosFichero;
    static  {
        dados = new ArrayList<>();
        dadosFichero = new File("dados.dat");

    }
    public static void main(String[] args){
        crearTiradas();
        escribirtirada();
        leerTiradas();


    }

    private static void leerTiradas() {
        FileInputStream fis;
        try {
            fis = new FileInputStream(dadosFichero);
            ObjectInputStream ois = new ObjectInputStream(fis);

            while (true){
                dado dadoo = (dado) ois.readObject();

                System.out.printf("La tirada es: %d%n",dadoo.getTirada());
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        catch (EOFException e){}
        catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void escribirtirada() {
        FileOutputStream fos;

        try {
            fos = new FileOutputStream(dadosFichero, true);
            ObjectOutputStream ous = new ObjectOutputStream(fos);
            for (dado da: dados
                 ) {
                ous.writeObject(da);

            }
            ous.close();
            fos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static void crearTiradas() {
        for (int i = 0; i < 1000; i++) {
            dados.add(new dado((int)(Math.random() *dado.CARAS +1)));

        }
    }


}
