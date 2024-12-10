package code.overcomplicatedobject;

import java.util.List;

public class Product {
    private List<Feature> features;

    public Product(List<Feature> features) {
        this.features = features;
    }

    public void listFeatures() {
        for (Feature feature : features) {
            feature.describe();
        }
    }

    public static void main(String[] args) {
        Product foldableSmartphone = new Product(List.of(new TouchScreenFeature(), new FoldableFeature()));
        foldableSmartphone.listFeatures();
    }
}

interface Feature {
    void describe();
}

class TouchScreenFeature implements Feature {
    @Override
    public void describe() {
        System.out.println("Touchscreen feature");
    }
}

class FoldableFeature implements Feature {
    @Override
    public void describe() {
        System.out.println("Foldable feature");
    }
}