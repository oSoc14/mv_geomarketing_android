package osoc14.okfn.geomarketing.database.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static List<DummyCoupon> COUPONS = new ArrayList<DummyCoupon>();
    public static List<DummyStore> STORES = new ArrayList<DummyStore>();
    /**
     * A map of sample (dummy) items, by ID.
     */
    //public static Map<String, DummyCoupon> ITEM_MAP = new HashMap<String, DummyCoupon>();

    static {
        // Add all fake Coupons
        addItem(new DummyCoupon("1", "Eén pak graties", "Frituur nadine"));
        addItem(new DummyCoupon("2", "20% korting", "Bakker jos"));
        addItem(new DummyCoupon("3", "Eindejaarsactie", "Pitta Istanbul"));
        addItem(new DummyCoupon("4", "2de pint graties", "Café de loge"));
        addItem(new DummyCoupon("5", "Graties worst", "Slager Bart"));
        addItem(new DummyCoupon("6", "Aan de helft van de prijs!", "Kapper Filip"));

        // Add all fake Stores
        addItem(new DummyStore("1", "Frietuur nadine"));
        addItem(new DummyStore("2", "Bakker jos"));
        addItem(new DummyStore("3", "Cafe de loge"));
        addItem(new DummyStore("4", "Pitta Istanbul"));
        addItem(new DummyStore("5", "Slager Bart"));
        addItem(new DummyStore("6", "Kapper Filip"));
    }

    private static void addItem(DummyCoupon item) {
        COUPONS.add(item);
        //ITEM_MAP.put(item.id, item);
    }

    private static void addItem(DummyStore item) {
        STORES.add(item);
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyCoupon {
        public String id;
        public String title;
        public String store;
        public String summary;



        public DummyCoupon(String id, String content, String store) {
            this.id = id;
            this.title = content;
            this.store = store;
        }



        @Override
        public String toString() {
            return title;
        }
    }

    public static  class DummyStore {
        public String id;
        public String name;
        public String summary;

        public DummyStore(String id, String name) {

            this.id = id;
            this.name = name;


        }

        @Override
        public String toString() {
            return name;
        }
    }
}
