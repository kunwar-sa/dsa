public class GarbageCollection {

    public static void main(String[] args) {

        String[] garbage = { "MMM", "PGM", "GP" };
        int[] travel = { 3, 10 };

        int ans = garbageCollection(garbage, travel);

        System.out.println(ans);
    }

    public static int garbageCollection(String[] garbage, int[] travel) {

        int ans = 0;
        int collectionTime = 0;

        int lenG = garbage.length;

        for (String gar : garbage) {
            collectionTime += gar.length();
        }

        // calculating travel time for paper truck
        int travelTimeP = 0;
        int lastHouseP = -1;

        for (int i = lenG - 1; i > -1; i--) {

            String assortment = garbage[i];
            int len = assortment.length();

            for (int j = len - 1; j > -1; j--) {
                if (assortment.charAt(j) == 'P') {
                    lastHouseP = i;
                    break;
                }
            }

            if (lastHouseP != -1)
                break;

        }

        for (int i = 0; i < lastHouseP; i++) {
            travelTimeP += travel[i];
        }

        // calculating travel time for glass truck
        int travelTimeG = 0;
        int lastHouseG = -1;

        for (int i = lenG - 1; i > -1; i--) {

            String assortment = garbage[i];
            int len = assortment.length();

            for (int j = len - 1; j > -1; j--) {
                if (assortment.charAt(j) == 'G') {
                    lastHouseG = i;
                    break;
                }
            }

            if (lastHouseG != -1)
                break;

        }

        for (int i = 0; i < lastHouseG; i++) {
            travelTimeG += travel[i];
        }

        // calculating travel time for metal truck
        int travelTimeM = 0;
        int lastHouseM = -1;

        for (int i = lenG - 1; i > -1; i--) {

            String assortment = garbage[i];
            int len = assortment.length();

            for (int j = len - 1; j > -1; j--) {
                if (assortment.charAt(j) == 'M') {
                    lastHouseM = i;
                    break;
                }
            }

            if (lastHouseM != -1)
                break;

        }

        for (int i = 0; i < lastHouseM; i++) {
            travelTimeM += travel[i];
        }

        ans = collectionTime + travelTimeG + travelTimeM + travelTimeP;

        return ans;
    }
}
