package CapstoneProjects.PatikaStore;

import java.util.ArrayList;

public class Brand implements Comparable<Brand>{

    private Long brandId;
    private String brandName;
    public static ArrayList<Brand> brands = new ArrayList<Brand>();

    public Brand(Long brandId, String brandName) {
        this.brandId = brandId;
        this.brandName = brandName;
        this.brands.add(this);
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    @Override
    public int compareTo(Brand o) {
        return this.brandName.compareTo(o.brandName);
    }

    public static void printBrands() {
        System.out.println(String.format("%-30s", "----- Our Brands -----\n"));
        for (int i = 0; i < brands.size(); i++) {
            System.out.println((i + 1) + " - " + brands.get(i).getBrandName());
        }
    }

    @Override
    public String toString() {
        return "- "+this.brandName;
    }
}
