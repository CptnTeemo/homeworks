public class Arithmetic {

    public int n1 = 0;
    public int n2 = 0;

    public Arithmetic(int x, int y) {
        n1 = x;
        n2 = y;
    }

    public int sum() {
        return n1 + n2;
    }

    public int multiplication() {
        return n1 * n2;
    }

    public int min() {
        if (n1 > n2) {
            return n2;
        } else {
            return n1;
        }
    }

    public int max() {
        if (n1 > n2) {
            return n1;
        } else {
            return n2;
        }
    }

}
