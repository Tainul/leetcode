public class GrumpyBookstoreOwner {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int happyCus = 0;
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) {
                happyCus += customers[i];
            }
            customers[i] *= grumpy[i];
            if (i > 0) {
                customers[i] += customers[i - 1];
            }
        }
        int max = customers[X - 1];
        for (int i = X; i < customers.length; i++) {
            max = Math.max(max, customers[i] - customers[i - X]);
        }
        return happyCus + max;
    }
}
