package layouts.ejemplo;

import javafx.scene.image.Image;

public class Contact {
    private String name;
    private String imagePath;

    public Contact(String name, String imagePath) {
        this.name = name;
        this.imagePath = imagePath;
    }

    public String getName() {
        return name;
    }

  
    @SuppressWarnings("exports")
    public Image getImage() {
        return new Image(imagePath);
    }
}


