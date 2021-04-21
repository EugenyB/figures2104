public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {                          // sprawdza, czy sa parametry
            System.out.print("NIEPOPRAWNE DANE");
            return;
        }

        int index = 1;                     //"normalne" indeksy
        for (int i = 0; i < args[0].length(); i++) {
            System.out.println();
            if (index >= args.length) {
                return;
            }
            char ch;
            switch (ch = args[0].charAt(i)) {
                case 'c':
                    if (args.length < index + 4) {        //sprawdza,czy wystarczy argumentow dla tworzenia figury
                        System.out.print("NIEPOPRAWNE DANE");
                        return;
                    }
                    double bok1 = 0;
                    double bok2 = 0;
                    double bok3 = 0;
                    double bok4 = 0;
                    double kat = 0;
                    try {
                        bok1 = Double.parseDouble(args[index]);
                        bok2 = Double.parseDouble(args[index + 1]);
                        bok3 = Double.parseDouble(args[index + 2]);
                        bok4 = Double.parseDouble(args[index + 3]);
                        kat = Double.parseDouble(args[index + 4]);
                    } catch (NumberFormatException ex) {
                        System.out.println("NIEPOPRAWNE DANE");
                        break;
                    } finally {
                        index = index + 5;
                    }

                    if (bok1 <= 0 || bok2 <= 0 || bok3 <= 0 || bok4 <= 0 || kat <= 0) {
                        System.out.println("NIEPOPRAWNE DANE");
                        break;
                    }

                    if (bok1 == bok2 && bok2 == bok3 && bok3 == bok4) {
                        if (kat == 90) {
                            Figura.K1 c = Figura.K1.KWADRAT;
                            c.bok = bok1;
                            System.out.println("Pole kwadratu " + c.ObliczPole());
                            System.out.println("Obwod kwadratu " + c.ObliczObwod());
                        } else if (kat > 0 && kat < 90) {
                            Figura.K2 c = Figura.K2.ROMB;
                            c.parametr1 = bok1;
                            c.parametr2 = kat;
                            System.out.println("Pole rombu " + c.ObliczPole());
                            System.out.println("Obwod rombu " + c.ObliczObwod());
                        } else {
                            System.out.println("Kat musi byc < 90");
                        }
                    } else if (((bok1 == bok2 && bok3 == bok4) || (bok1 == bok3 && bok2 == bok4) || (bok1 == bok4 && bok2 == bok3)) && kat == 90) {
                        Figura.K2 c = Figura.K2.PROSTOKAT;
                        c.parametr1 = Double.max(Double.max(bok1, bok2), Double.max(bok3, bok4));
                        c.parametr2 = Double.min(Double.min(bok1, bok2), Double.min(bok3, bok4));
                        System.out.println("Pole prostokatu " + c.ObliczPole());
                        System.out.println("Obwod prostokatu " + c.ObliczObwod());
                    } else {
                        System.out.println("NIEPOPRAWNE DANE");
                    }
                    break;

                case 'o':
                    if (args.length < index) {
                        System.out.println("NIEPOPRAWNE DANE");
                        return;
                    }

                    double promien = 0;
                    try {
                        promien = Double.parseDouble(args[index]);
                    } catch (NumberFormatException ex) {
                        System.out.println("NIEPOPRAWNE DANE");
                        break;
                    } finally {
                        index++;
                    }

                    if (promien < 0) {
                        System.out.println("NIEPOPRAWNE DANE");
                        break;
                    }

                    Figura.K1 c = Figura.K1.OKRAG;
                    c.bok = promien;
                    System.out.println("Pole okragu " + c.ObliczPole());
                    System.out.println("Obwod okragu " + c.ObliczObwod());

                    break;

                case 'p':
                case 's':
                    if (args.length < index) {
                        System.out.print("NIEPOPRAWNE DANE");
                        return;
                    }
                    double bok = 0;
                    try {
                        bok = Double.parseDouble(args[index]);
                    } catch (NumberFormatException ex) {
                        System.out.println("NIEPOPRAWNE DANE");
                        break;
                    } finally {
                        index++;
                    }

                    if (bok < 0) {
                        System.out.println("NIEPOPRAWNE DANE");
                        break;
                    }
                    if (ch == 'p') {
                        Figura.K1 p = Figura.K1.PIECOKAT;
                        p.bok = bok;
                        System.out.println("Pole piecokatu " + p.ObliczPole());
                        System.out.println("Obwod piecokatu " + p.ObliczObwod());
                    } else {
                        Figura.K1 s = Figura.K1.SZESCIOKAT;
                        s.bok = bok;
                        System.out.println("Pole szesciokatu " + s.ObliczPole());
                        System.out.println("Obwod szesciokatu " + s.ObliczObwod());
                    }

                    break;

                default:
                    System.out.println("NIEPOPRAWNE DANE");
                    return;
            }
        }
    }
}

