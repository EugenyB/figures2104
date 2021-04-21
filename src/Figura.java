public class Figura {
    public enum K1 {

        OKRAG {
            public double ObliczPole() {
                return bok * bok * Math.PI;
            }

            public double ObliczObwod() {
                return 2 * bok * Math.PI;
            }
        },
        KWADRAT {
            public double ObliczPole() {
                return bok * bok;
            }

            public double ObliczObwod() {
                return 4 * bok;
            }
        },
        PIECOKAT {
            public double ObliczPole() {
                return bok * bok / 4 * Math.sqrt(25 + Math.sqrt(500));
            }

            public double ObliczObwod() {
                return 5 * bok;
            }
        },
        SZESCIOKAT {
            public double ObliczPole() {
                return bok * bok * Math.sqrt(6.75);
            }

            public double ObliczObwod() {
                return 6 * bok;
            }
        };
        public double bok;

        public abstract double ObliczPole();

        public abstract double ObliczObwod();


    }

    public enum K2 {

        PROSTOKAT {
            public double ObliczPole() {
                return parametr1 * parametr2;
            }

            public double ObliczObwod() {
                return 2 * (parametr1 + parametr2);
            }
        },
        ROMB {
            public double ObliczPole() {
                return parametr1 * parametr1 * Math.sin(Math.PI * parametr2 / 180);
            }

            public double ObliczObwod() {
                return parametr1 * 4;
            }
        };

        double parametr1;
        double parametr2;

        public abstract double ObliczPole();

        public abstract double ObliczObwod();
    }
}