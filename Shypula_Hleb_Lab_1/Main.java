// Napisz program, który wygeneruje n pseudolosowych punktów, znajdujących się wewnątrz elipsy o zadanej półosi małej amax i wielkiej bmax. Liczby n oraz amax i bmax niech będą parametrami wywołania programu.

// Wypisz współrzędne wylosowanych punktów w postaci dwóch kolumn, przekieruj je do pliku tekstowego ellipse.dat. Dla testu narysuj punkty przy pomocy dołączonego do zajęć skryptu gnuplota gnuplot_ellipse.sh lub w inny dowolny sposób.

import java.io.FileWriter;
import java.io.IOException;

class Main {
  public static void main(String[] args) throws IOException {

    int n = Integer.parseInt(args[0]);
    float amax = Float.parseFloat(args[1]);
    float bmax = Float.parseFloat(args[2]);

    Point point = new Point();

    FileWriter file = new FileWriter("Points.dat", true);

    while(n > 0)
    {
      if(point.genPoint(amax, bmax))
      {
        file.write(point.toString() + "\n");
        point.print();
        n--;
      }
    }

    file.close();
    
  }
}