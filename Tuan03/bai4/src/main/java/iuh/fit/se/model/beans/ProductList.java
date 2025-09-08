package iuh.fit.se.model.beans;

import java.util.ArrayList;
import java.util.List;

public class ProductList {
    private static final List<Product> ds = new ArrayList<>();

    static {
        initData();
    }

    public static List<Product> queryProducts() {
        return ds;
    }

    private static void initData() {
        Product sp;

        sp = new Product("PRO01", "Nokia Lumia", "", 10, 99000, "img/hinh1.jpg");
        ds.add(sp);

        sp = new Product("PRO02", "BlackBerry Passport", "", 10, 48000, "img/hinh1.jpg");
        ds.add(sp);

        sp = new Product("PRO03", "Sony Xperia Z5", "", 10, 52000, "img/hinh1.jpg");
        ds.add(sp);

        sp = new Product("PRO04", "HTC One M9", "", 10, 83000, "img/hinh1.jpg");
        ds.add(sp);

        sp = new Product("PRO05", "Samsung Galaxy Note 5", "", 10, 71000, "img/hinh1.jpg");
        ds.add(sp);

        sp = new Product("PRO06", "iPhone 7 jet-black Plus", "", 10, 120000, "img/hinh1.jpg");
        ds.add(sp);
    }
}